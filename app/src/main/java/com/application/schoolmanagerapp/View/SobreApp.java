package com.application.schoolmanagerapp.View;

import android.os.Bundle;

import com.application.schoolmanagerapp.Presenter.MyPresenterFormulario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.application.schoolmanagerapp.R;

public class SobreApp extends AppCompatActivity {

    String TAG = "SchoolManagerApp/SobreApp";

    public void terminarSobreApp(){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Ejecutando onCreate...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView backBoton = findViewById(R.id.backSobreApp);
        backBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terminarSobreApp();
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
