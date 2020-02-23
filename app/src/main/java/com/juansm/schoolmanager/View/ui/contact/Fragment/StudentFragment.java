package com.juansm.schoolmanager.View.ui.contact.Fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.juansm.schoolmanager.Model.Entities.Gender;
import com.juansm.schoolmanager.Model.Entities.Student;
import com.juansm.schoolmanager.Presenter.GenderPresenter;
import com.juansm.schoolmanager.Presenter.StudentPresenter;
import com.juansm.schoolmanager.R;
import com.juansm.schoolmanager.TheApplication;
import com.juansm.schoolmanager.View.ui.contact.ContactsViewModel;
import com.juansm.schoolmanager.View.ui.contact.Adapter.StudentAdapter;
import com.juansm.schoolmanager.View.ui.contact.ControllerSwipe.SwipeStudentController;
import com.juansm.schoolmanager.View.utils.ChooseDatePickerDialog;

import java.util.List;

public class StudentFragment extends Fragment {

    String TAG = "SchoolManager/Fragments/StudentFragment";

    public static final String STUDENT_KEY = "STUDENT";
    public static final String POSITION_KEY = "POSITION";
    public static final int REQUEST_CODE_NEW_STUDENT = 3;
    public static final int REQUEST_CODE_EXITS_STUDENT = 2;
    public static final int RESULT_CODE_ACCEPT = 1;
    public static final int RESULT_CODE_DELETE = 0;

    private ContactsViewModel contactsViewModel;
    private StudentAdapter studentAdapter;
    private ChooseDatePickerDialog chooseDatePickerDialog;
    private ArrayAdapter<Gender> arrayAdapterGender;
    private List<Gender> genders;
    private boolean beAbleSearch, loaded;

    private LinearLayout linearLayoutSearch;
    private TextView countStudent;
    private RecyclerView recyclerView;
    private FloatingActionButton fabNewStudent;
    private AppCompatSpinner spinnerSearchGender;
    private ImageButton buttonCloseSearch, buttonRefreshSearch;
    private SearchView searchView;
    private ImageView iconDateSearch;
    private TextInputEditText editTextDateSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "Entrando en onCreateView...");

        View root = inflater.inflate(R.layout.fragment_contacts_student, container, false);
        this.beAbleSearch = true;
        this.loaded = false;

        this.linearLayoutSearch = root.findViewById(R.id.linearlayout_search_student);
        this.chooseDatePickerDialog = new ChooseDatePickerDialog();
        this.spinnerSearchGender = root.findViewById(R.id.spinner_gender_search);
        this.buttonRefreshSearch = root.findViewById(R.id.refresh_search);
        this.buttonCloseSearch = root.findViewById(R.id.close_search);
        this.searchView = root.findViewById(R.id.search_view_student);
        this.iconDateSearch = root.findViewById(R.id.icon_date_search);
        this.editTextDateSearch = root.findViewById(R.id.edittext_date_search);
        this.countStudent = root.findViewById(R.id.countStudent);
        this.recyclerView = root.findViewById(R.id.recyclerview_student);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        this.studentAdapter = new StudentAdapter();
        this.recyclerView.setAdapter(this.studentAdapter);

        this.fabNewStudent = root.findViewById(R.id.fab_new_student);

        this.refreshSearch();
        this.setUpView();

        setHasOptionsMenu(true);
        return root;
    }

    private void refreshSearch() {
        this.searchView.setQuery("", false);
        this.editTextDateSearch.setText("");
        genders = GenderPresenter.getInstance().readGenders();
        genders.add(0, new Gender((long) -1, getString(R.string.option_default_spinner_gender), ""));
        arrayAdapterGender = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, genders);
        spinnerSearchGender.setAdapter(arrayAdapterGender);
    }

    private void setUpView() {
        this.buttonCloseSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutSearch.setVisibility(LinearLayout.GONE);
            }
        });
        this.buttonRefreshSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSearch();
            }
        });

        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (beAbleSearch) {
                    searchStudents();
                    beAbleSearch = false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            beAbleSearch = true;
                        }
                    }, 200);

                }
                return false;
            }
        });
        this.editTextDateSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.equals("") || new Student().setBirthDate(s.toString())) {
                    searchStudents();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        this.iconDateSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= chooseDatePickerDialog.createAndShowDatePicker(getContext(),
                        editTextDateSearch.getText().toString());
                datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        String dateChoose = chooseDatePickerDialog.getResultDate();
                        editTextDateSearch.setText(dateChoose);
                    }
                });
            }
        });

        this.spinnerSearchGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (loaded){
                    searchStudents();
                }else{
                    loaded = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.studentAdapter.setNewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                Intent i = new Intent(TheApplication.getContext(), FormStudent.class);
                i.putExtra(STUDENT_KEY, studentAdapter.getItemId(position));
                i.putExtra(POSITION_KEY, position);
                startActivityForResult(i, REQUEST_CODE_EXITS_STUDENT);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeStudentController());
        //itemTouchHelper.attachToRecyclerView(this.recyclerView);

        this.fabNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TheApplication.getContext(), FormStudent.class);
                startActivityForResult(i, REQUEST_CODE_NEW_STUDENT);
            }
        });
    }

    private void searchStudents(){
        String query = this.searchView.getQuery().toString(),
                date = this.editTextDateSearch.getText().toString();
        Long idGender = ((Gender)this.spinnerSearchGender.getSelectedItem()).getId();
        Log.d(TAG,"Query: "+query);
        Log.d(TAG,"Date: "+date);
        Log.d(TAG,"idGender: "+idGender);

        if(query.equals("")&&date.equals("")&&idGender<0){
            this.contactsViewModel.setStudents(StudentPresenter.getInstance().readStudents());
        }else{
            this.contactsViewModel.setStudents(StudentPresenter.getInstance().readStudentsByCriteriaReduced(query, date, idGender));
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Entrando en onActivityCreated...");

        contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel.class);
        contactsViewModel.getStudents().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> list) {
                studentAdapter.setStudents(list);
                String text;
                if (list != null) {
                    text = list.size() + getString(R.string.label_countListStudent);
                } else {
                    text = "0" + getString(R.string.label_countListStudent);
                }
                countStudent.setText(text);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "Entrando en onOptionsItemSelected...");

        switch (item.getItemId()) {
            case R.id.menu_sort_contact:
                Log.d(TAG, "sort");
                return true;
            case R.id.menu_search_contact:
                this.linearLayoutSearch.setVisibility(LinearLayout.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_NEW_STUDENT:
                if (resultCode == RESULT_CODE_ACCEPT) {
                    if (data != null) {
                        Student stud = data.getParcelableExtra(STUDENT_KEY);
                        if (stud != null) {
                            this.contactsViewModel.addStudent(stud);
                        }
                    }
                }
                break;
            case REQUEST_CODE_EXITS_STUDENT:
                if (resultCode == RESULT_CODE_ACCEPT) {
                    if (data != null) {
                        Student stud = data.getParcelableExtra(STUDENT_KEY);
                        int position = data.getIntExtra(POSITION_KEY, -1);
                        if (stud != null && position > -1) {
                            this.contactsViewModel.changeStudent(position, stud);
                        }
                    }
                } else if (resultCode == RESULT_CODE_DELETE) {
                    if (data != null) {
                        int position = data.getIntExtra(POSITION_KEY, -1);
                        if (position > -1) {
                            this.contactsViewModel.removeStudent(position);
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }
}
