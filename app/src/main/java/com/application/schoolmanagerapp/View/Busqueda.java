package com.application.schoolmanagerapp.View;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import com.application.schoolmanagerapp.Presenter.MyPresenterBusqueda;
import com.application.schoolmanagerapp.Presenter.MyPresenterFormulario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.schoolmanagerapp.R;

import java.util.Calendar;

public class Busqueda extends AppCompatActivity {

    String TAG = "SchoolManagerApp/Busqueda";
    Context content;

    public void terminarBusqueda(){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        content = this;
        Log.d(TAG, "Ejecutando onCreate...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button botonBuscar = findViewById(R.id.botonBuscar);
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPresenterBusqueda.getInstance().buscar();
                terminarBusqueda();
            }
        });

        ImageView backBoton = findViewById(R.id.backBusqueda);
        backBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terminarBusqueda();
            }
        });

        Button botonDate = findViewById(R.id.botonDateBusqueda);
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
                        ((EditText)findViewById(R.id.dateTextBusqueda)).setText(diaFormateado + "/" + mesFormateado + "/" + year);


                    }

                },anio, mes, dia);

                recogerFecha.show();

            }
        });
        darValidacion();
    }

    private void darValidacion(){
        final TextView errorNombre = findViewById(R.id.errorNombreBusqueda);

        final EditText txtEditNombre = (EditText) findViewById(R.id.nombreBusqueda);
        txtEditNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterBusqueda.getInstance().validarFormulario("nombre", txtEditNombre.getText().toString())){
                        errorNombre.setVisibility(View.INVISIBLE);
                    }else{
                        errorNombre.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final EditText txtEditApellidos = (EditText) findViewById(R.id.apellidosBusqueda);
        txtEditApellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterBusqueda.getInstance().validarFormulario("apellidos", txtEditApellidos.getText().toString())){
                        errorNombre.setVisibility(View.INVISIBLE);
                    }else{
                        errorNombre.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final TextView errorFecha = findViewById(R.id.errorFechaBusqueda);
        final EditText txtEditFecha = (EditText) findViewById(R.id.dateTextBusqueda);
        txtEditFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterBusqueda.getInstance().validarFormulario("fecha", txtEditFecha.getText().toString())){
                        errorFecha.setVisibility(View.INVISIBLE);
                    }else{
                        errorFecha.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        final TextView errorTelefono = findViewById(R.id.errorTelefonoBusqueda);
        final EditText txtEditTelefono = (EditText) findViewById(R.id.telefonoTextBusqueda);
        txtEditTelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (MyPresenterBusqueda.getInstance().validarFormulario("telefono", txtEditTelefono.getText().toString())){
                        errorTelefono.setVisibility(View.INVISIBLE);
                    }else{
                        errorTelefono.setVisibility(View.VISIBLE);
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
