package com.juansm.schoolmanager.View.ui.contact.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;
import com.juansm.schoolmanager.Model.Entities.Gender;
import com.juansm.schoolmanager.Model.Entities.Student;
import com.juansm.schoolmanager.Presenter.GenderPresenter;
import com.juansm.schoolmanager.Presenter.StudentPresenter;
import com.juansm.schoolmanager.R;
import com.juansm.schoolmanager.View.utils.ChooseDatePickerDialog;
import com.juansm.schoolmanager.View.utils.ConfirmationAlertDialog;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormStudent extends AppCompatActivity {

    String TAG = "SchoolManager/FormStudent";
    public static final int PICK_FROM_GALLERY = 1;


    private ConfirmationAlertDialog confirmationAlertDialog;
    private ChooseDatePickerDialog chooseDatePickerDialog;
    private HashMap<String, Boolean> conditions;
    private Student student;
    int position;
    private List<Gender> genders;
    private ImageView img_profile;
    private TextInputLayout til_name, til_lastname, til_phone, til_email, til_address, til_name_father,
            til_phone_father, til_name_mother, til_phone_mother, til_date, til_spinner_gender;
    private AppCompatSpinner spinnerGender;
    private ArrayAdapter<Gender> arrayAdapterGender;
    private ImageButton buttonAddGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entrando en onCreate...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.confirmationAlertDialog = new ConfirmationAlertDialog();
        this.chooseDatePickerDialog = new ChooseDatePickerDialog();

        this.student = new Student();
        img_profile = findViewById(R.id.image_form_student_profile);
        til_name = findViewById(R.id.til_name);
        til_lastname = findViewById(R.id.til_lastname);
        til_phone = findViewById(R.id.til_phone);
        til_email = findViewById(R.id.til_email);
        til_address = findViewById(R.id.til_address);
        til_name_father = findViewById(R.id.til_name_father);
        til_name_mother = findViewById(R.id.til_name_mother);
        til_phone_father = findViewById(R.id.til_phone_father);
        til_phone_mother = findViewById(R.id.til_phone_mother);
        til_date = findViewById(R.id.til_date);
        til_spinner_gender = findViewById(R.id.til_spinner_gender);
        spinnerGender = findViewById(R.id.spinner_gender);
        buttonAddGender = findViewById(R.id.add_new_gender_button);

        genders = GenderPresenter.getInstance().readGenders();
        genders.add(0, new Gender((long) -1, getString(R.string.option_default_spinner_gender), ""));
        arrayAdapterGender = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genders);
        spinnerGender.setAdapter(arrayAdapterGender);


        this.conditions = new HashMap<>();
        this.conditions.put("name", false);
        this.conditions.put("phone", false);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(StudentFragment.STUDENT_KEY);
            this.position = bundle.getInt(StudentFragment.POSITION_KEY);
            if (id != 0L) {
                this.setStudent(StudentPresenter.getInstance().readStudentById(id));
            }
        }

        this.setUpView();
    }

    private void setStudent(Student stud) {
        if (stud != null) {
            this.student = stud;
            this.loadStudentView();
        }
    }

    private void loadImageProfile(){
        if (this.student.getImg() != null && !this.student.getImg().equals("")) {
            byte[] decodedImg = Base64.decode(this.student.getImg(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedImg, 0, decodedImg.length);

            this.img_profile.setImageBitmap(bitmap);
        }
    }
    private void loadStudentView() {
        this.conditions.put("name", true);
        this.conditions.put("phone", true);
        loadImageProfile();
        this.til_name.getEditText().setText(this.student.getName());
        this.til_lastname.getEditText().setText(this.student.getLastName());
        this.til_phone.getEditText().setText(this.student.getPhone());
        this.til_email.getEditText().setText(this.student.getEmail());
        this.til_address.getEditText().setText(this.student.getAddress());
        this.til_name_father.getEditText().setText(this.student.getNameFather());
        this.til_name_mother.getEditText().setText(this.student.getNameMother());
        this.til_phone_father.getEditText().setText(this.student.getFatherPhone());
        this.til_phone_mother.getEditText().setText(this.student.getMotherPhone());
        this.til_date.getEditText().setText(this.student.getBirthDate());
        this.setGenderSpinner(this.student.getIdGender());
    }

    private void setGenderSpinner(Long id) {
        boolean flag = true;
        for (int i = 0; i < genders.size() && flag; i++) {
            if (id == genders.get(i).getId()) {
                this.spinnerGender.setSelection(i);
                flag = false;
            }
        }
    }

    private void setUpView() {

        this.img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImageProfile();
            }
        });

        this.til_name.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_name.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setName(value)) {
                            til_name.setError(null);
                            conditions.put("name", true);
                        } else {
                            til_name.setError(getString(R.string.error_name_person));
                            conditions.put("name", false);
                        }
                    } else {
                        til_name.setError(getString(R.string.error_empty_name_person));
                        conditions.put("name", false);
                    }
                }
            }
        });
        this.til_name.getEditText().requestFocus();
        getCurrentFocus().clearFocus();


        this.til_lastname.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_lastname.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setLastName(value)) {
                            til_lastname.setError(null);
                            conditions.put("lastname", true);
                        } else {
                            til_lastname.setError(getString(R.string.error_lastname_person));
                            conditions.put("lastname", false);
                        }
                    } else {
                        til_lastname.setError(null);
                        conditions.put("lastname", true);
                    }
                }
            }
        });


        this.til_phone.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_phone.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setPhone(value)) {
                            til_phone.setError(null);
                            conditions.put("phone", true);
                        } else {
                            til_phone.setError(getString(R.string.error_phone_person));
                            conditions.put("phone", false);
                        }
                    } else {
                        conditions.put("phone", false);
                        til_phone.setError(getString(R.string.error_empty_phone_person));
                    }
                }
            }
        });
        this.til_phone.getEditText().requestFocus();
        getCurrentFocus().clearFocus();


        this.til_email.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_email.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setEmail(value)) {
                            til_email.setError(null);
                            conditions.put("email", true);
                        } else {
                            til_email.setError(getString(R.string.error_email_person));
                            conditions.put("email", false);
                        }
                    } else {
                        til_email.setError(null);
                        conditions.put("email", true);
                    }
                }
            }
        });


        this.til_address.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_address.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setAddress(value)) {
                            til_address.setError(null);
                            conditions.put("address", true);
                        } else {
                            til_address.setError(getString(R.string.error_address_person));
                            conditions.put("address", false);
                        }
                    } else {
                        til_address.setError(null);
                        conditions.put("address", true);
                    }
                }
            }
        });


        this.til_name_father.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_name_father.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setNameFather(value)) {
                            til_name_father.setError(null);
                            conditions.put("namefather", true);
                        } else {
                            til_name_father.setError(getString(R.string.error_name_person));
                            conditions.put("namefather", false);
                        }
                    } else {
                        til_name_father.setError(null);
                        conditions.put("namefather", true);
                    }
                }
            }
        });


        this.til_name_mother.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_name_mother.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setNameMother(value)) {
                            til_name_mother.setError(null);
                            conditions.put("namemother", true);
                        } else {
                            til_name_mother.setError(getString(R.string.error_name_person));
                            conditions.put("namemother", false);
                        }
                    } else {
                        til_name_mother.setError(null);
                        conditions.put("namemother", true);
                    }
                }
            }
        });


        this.til_phone_father.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_phone_father.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setFatherPhone(value)) {
                            til_phone_father.setError(null);
                            conditions.put("phonefather", true);
                        } else {
                            til_phone_father.setError(getString(R.string.error_phone_person));
                            conditions.put("phonefather", false);
                        }
                    } else {
                        til_phone_father.setError(null);
                        conditions.put("phonefather", true);
                    }
                }
            }
        });


        this.til_phone_mother.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_phone_mother.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setMotherPhone(value)) {
                            til_phone_mother.setError(null);
                            conditions.put("phonemother", true);
                        } else {
                            til_phone_mother.setError(getString(R.string.error_phone_person));
                            conditions.put("phonemother", false);
                        }
                    } else {
                        til_phone_mother.setError(null);
                        conditions.put("phonemother", true);
                    }
                }
            }
        });


        this.til_date.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String value = til_date.getEditText().getText().toString();
                    if (!value.equals("")) {
                        if (student.setBirthDate(value)) {
                            til_date.setError(null);
                            conditions.put("date", true);
                        } else {
                            til_date.setError(getString(R.string.error_birthdate_person));
                            conditions.put("date", false);
                        }
                    } else {
                        til_date.setError(null);
                        conditions.put("date", true);
                    }
                }
            }
        });

        ImageView iconDate = findViewById(R.id.icon_date);
        iconDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog= chooseDatePickerDialog.createAndShowDatePicker(FormStudent.this,
                        student.getBirthDate());
                datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        String dateChoose = chooseDatePickerDialog.getResultDate();
                        til_date.getEditText().setText(dateChoose);
                        til_date.getEditText().requestFocus();
                        til_date.getEditText().clearFocus();
                    }
                });
            }
        });

        this.buttonAddGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FormStudent.this);
                LayoutInflater inflater = FormStudent.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_new_gender, null);
                final EditText textName = view.findViewById(R.id.edittext_name_new_gender);
                final EditText textDescription = view.findViewById(R.id.edittext_description_new_gender);
                builder.setView(view)
                        .setPositiveButton(getString(R.string.text_button_accept), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Gender gender = new Gender();
                                gender.setName(textName.getText().toString());
                                gender.setDescription(textDescription.getText().toString());
                                Long idNewGender = GenderPresenter.getInstance().insertNewGender(gender);
                                gender.setId(idNewGender);
                                genders.add(gender);
                                setGenderSpinner(idNewGender);

                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(getString(R.string.text_button_cancel), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
            }
        });
        this.spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Gender gender = arrayAdapterGender.getItem(position);

                if (gender.getId() != -1) {
                    if (student.setIdGender(gender.getId())) {
                        til_spinner_gender.setError(null);
                        conditions.put("gender", true);
                    } else {
                        til_spinner_gender.setError(getString(R.string.error_gender_person));
                        conditions.put("gender", false);
                    }
                } else {
                    student.setIdGender((long)0);
                    til_spinner_gender.setError(null);
                    conditions.put("gender", true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private boolean formIsValid() {
        boolean flag = true;
        for (Map.Entry<String, Boolean> entry : this.conditions.entrySet()) {
            if (!entry.getValue()) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "Entrando en onCreateOptionsMenu...");
        menu.clear();
        getMenuInflater().inflate(R.menu.options_form_contact_menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "Entrando en onOptionsItemSelected...");

        View v = getCurrentFocus();
        if (v != null) {
            v.clearFocus();
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_save_contact:
                if (this.student.isValid() && this.formIsValid()) {
                    AlertDialog alertDialog = this.confirmationAlertDialog.createAndShowConfirmDialog(FormStudent.this,
                            getString(R.string.title_alert_save_contact), getString(R.string.message_alert_save_contact));

                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            if (confirmationAlertDialog.getResultCode() == confirmationAlertDialog.RESULT_CODE_POSITIVE){
                                Intent i = new Intent();
                                if (student.getId() != null) {

                                    if (StudentPresenter.getInstance().modifyExitStudent(student)) {
                                        i.putExtra(StudentFragment.STUDENT_KEY, student);
                                        i.putExtra(StudentFragment.POSITION_KEY, position);
                                        setResult(StudentFragment.RESULT_CODE_ACCEPT, i);

                                    }

                                } else {
                                    Long idNew = StudentPresenter.getInstance().insertNewStudent(student);
                                    if (idNew > -1) {
                                        student.setId(idNew);
                                        i.putExtra(StudentFragment.STUDENT_KEY, student);
                                        setResult(StudentFragment.RESULT_CODE_ACCEPT, i);
                                    }

                                }
                                finish();
                            }
                        }
                    });

                    return true;
                } else {
                    return false;
                }

            case R.id.menu_remove_contact:
                if (this.student.getId() != null) {
                    AlertDialog alertDialog = this.confirmationAlertDialog.createAndShowConfirmDialog(FormStudent.this,
                            getString(R.string.title_alert_remove_contact), getString(R.string.message_alert_remove_contact));

                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            if (confirmationAlertDialog.getResultCode() == confirmationAlertDialog.RESULT_CODE_POSITIVE){
                                Intent i = new Intent();
                                if (StudentPresenter.getInstance().removeStudent(student.getId())) {
                                    i.putExtra(StudentFragment.POSITION_KEY, position);
                                    setResult(StudentFragment.RESULT_CODE_DELETE, i);
                                }
                                finish();
                            }
                        }
                    });
                    return true;
                }else{
                    finish();
                    return false;
                }
            case R.id.menu_help_contact:
                Log.d(TAG, "help");
                return true;
            case R.id.menu_about:
                Log.d(TAG, "about");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadImageOfGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_FROM_GALLERY);
    }
    private void changeImageProfile(){
        try {
            if (ContextCompat.checkSelfPermission(FormStudent.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(FormStudent.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PICK_FROM_GALLERY);
            } else {
                this.loadImageOfGallery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG,"RESPUESTA DE PEDIR PERMISOS");
        switch (requestCode){
            case PICK_FROM_GALLERY:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    this.loadImageOfGallery();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case PICK_FROM_GALLERY:
                if (resultCode == RESULT_OK && data != null) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    if (selectedImage!=null){
                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        if (cursor != null){
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            String picturePath = cursor.getString(columnIndex);
                            cursor.close();

                            Bitmap bm = BitmapFactory.decodeFile(picturePath);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                            byte[] byteArrayImage = baos.toByteArray();
                            String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
                            this.student.setImg(encodedImage);
                            this.loadImageProfile();
                        }
                    }
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Ejecutando onRestart...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }

}
