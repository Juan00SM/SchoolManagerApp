package com.application.schoolmanagerapp.View;

import android.content.Intent;
import android.os.Bundle;

import com.application.schoolmanagerapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView guardarBoton = findViewById(R.id.guardar);
        ImageView backBoton = findViewById(R.id.back);
        guardarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Formulario.this, ListaContactos.class);
                startActivity(intent);
            }
        });
        backBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Formulario.this, ListaContactos.class);
                startActivity(intent);
            }
        });
    }

}
