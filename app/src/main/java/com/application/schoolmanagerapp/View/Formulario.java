package com.application.schoolmanagerapp.View;

import android.content.Intent;
import android.os.Bundle;

import com.application.schoolmanagerapp.Interfaces.ListadoInterface;
import com.application.schoolmanagerapp.Presenter.MyPresenterFormulario;
import com.application.schoolmanagerapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Formulario extends AppCompatActivity implements ListadoInterface.ViewFormulario {

    String TAG = "SchoolManagerApp/Formulario";


    public void terminarFormulario(){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView guardarBoton = findViewById(R.id.save);
        ImageView backBoton = findViewById(R.id.back);
        guardarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPresenterFormulario.getInstance().onClickAdd();
                terminarFormulario();
            }
        });
        backBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPresenterFormulario.getInstance().onClickAdd();
                terminarFormulario();
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
