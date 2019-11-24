package com.application.schoolmanagerapp.View;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.application.schoolmanagerapp.Interfaces.ListadoInterface;
import com.application.schoolmanagerapp.Presenter.MyPresenterFormulario;
import com.application.schoolmanagerapp.R;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Formulario extends AppCompatActivity implements ListadoInterface.ViewFormulario {

    String TAG = "SchoolManagerApp/Formulario";
    Context content;

    public void terminarFormulario(){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Ejecutando onCreate...");
        content = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView guardarBoton = findViewById(R.id.save);
        ImageView backBoton = findViewById(R.id.back);
        ImageView eliminarBoton = findViewById(R.id.remove);
        guardarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPresenterFormulario.getInstance().guardarNuevo();
                terminarFormulario();
            }
        });

        eliminarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(content);
                alertDialog.setTitle("Confirmacion para eliminar");
                alertDialog.setMessage("¿Estas seguro que quieres eliminar el registro?");


                alertDialog.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MyPresenterFormulario.getInstance().eliminarRegistro();
                                terminarFormulario();
                            }
                        });
                alertDialog.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });
        backBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPresenterFormulario.getInstance().cancelarNuevo();
                terminarFormulario();
            }
        });
        Button botonDate = findViewById(R.id.botonDate);
        botonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calendario para obtener fecha & hora
                final Calendar c = Calendar.getInstance();

                //Variables para obtener la fecha
                final int mes = c.get(Calendar.MONTH);
                final int dia = c.get(Calendar.DAY_OF_MONTH);
                final int anio = c.get(Calendar.YEAR);
                DatePickerDialog recogerFecha = new DatePickerDialog(content, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                        final int mesActual = month + 1;
                        //Formateo el día obtenido: antepone el 0 si son menores de 10
                        String diaFormateado = (dayOfMonth < 10)? 0 + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                        //Formateo el mes obtenido: antepone el 0 si son menores de 10
                        String mesFormateado = (mesActual < 10)? 0 + String.valueOf(mesActual):String.valueOf(mesActual);
                        //Muestro la fecha con el formato deseado
                        ((EditText)findViewById(R.id.dateText)).setText(diaFormateado + "/" + mesFormateado + "/" + year);


                    }

                },anio, mes, dia);

                recogerFecha.show();

            }
        });
        Button botonAnadirOpcion = findViewById(R.id.botonAnadirOpcion);
        botonAnadirOpcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(content);
                alertDialog.setTitle("Añadir nueva opción");
                alertDialog.setMessage("Opcion a añadir:");
                final EditText input = new EditText(content);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                alertDialog.setPositiveButton("Añadir",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String opcion = input.getText().toString();
                                if (!opcion.equals("")) {
                                    Spinner spinner = findViewById(R.id.sexoSpinner);


                                    Resources res = getResources();
                                    String[] items =  res.getStringArray(R.array.listaopcionessexo);
                                    ArrayList<String> nuevosItems = new ArrayList<>();
                                    for(String item: items){
                                        nuevosItems.add(item);
                                    }
                                    nuevosItems.add(opcion);
                                    ArrayAdapter<String> adp = new ArrayAdapter<>(content, android.R.layout.simple_list_item_1);
                                    adp.addAll(nuevosItems);
                                    adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner.setAdapter(adp);
                                }
                            }
                        });
                alertDialog.setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();

            }
        });
        darValidacion();
    }
    private void darValidacion(){
        final TextView errorNombre = findViewById(R.id.errorNombre);

        final EditText txtEditNombre = (EditText) findViewById(R.id.nombre);
        txtEditNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterFormulario.getInstance().validarFormulario("nombre", txtEditNombre.getText().toString())){
                        errorNombre.setVisibility(View.INVISIBLE);
                    }else{
                        errorNombre.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final EditText txtEditApellidos = (EditText) findViewById(R.id.apellidos);
        txtEditApellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterFormulario.getInstance().validarFormulario("apellidos", txtEditApellidos.getText().toString())){
                        errorNombre.setVisibility(View.INVISIBLE);
                    }else{
                        errorNombre.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final TextView errorFecha = findViewById(R.id.errorFecha);
        final EditText txtEditFecha = (EditText) findViewById(R.id.dateText);
        txtEditFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterFormulario.getInstance().validarFormulario("fecha", txtEditFecha.getText().toString())){
                        errorFecha.setVisibility(View.INVISIBLE);
                    }else{
                        errorFecha.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final TextView errorTelefono = findViewById(R.id.errorTelefono);
        final EditText txtEditTelefono = (EditText) findViewById(R.id.telefonoText);
        txtEditTelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterFormulario.getInstance().validarFormulario("telefono", txtEditTelefono.getText().toString())){
                        errorTelefono.setVisibility(View.INVISIBLE);
                    }else{
                        errorTelefono.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final TextView errorEmail = findViewById(R.id.errorEmail);
        final EditText txtEditEmail = (EditText) findViewById(R.id.emailText);
        txtEditEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterFormulario.getInstance().validarFormulario("email", txtEditEmail.getText().toString())){
                        errorEmail.setVisibility(View.INVISIBLE);
                    }else{
                        errorEmail.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Ejecutando onRestart...");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }

}
