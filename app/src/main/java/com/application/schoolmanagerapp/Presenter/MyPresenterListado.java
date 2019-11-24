package com.application.schoolmanagerapp.Presenter;

import android.content.Context;
import android.content.Intent;

import com.application.schoolmanagerapp.Interfaces.ListadoInterface;
import com.application.schoolmanagerapp.View.Busqueda;
import com.application.schoolmanagerapp.View.Formulario;
import com.application.schoolmanagerapp.View.SobreApp;

public class MyPresenterListado implements ListadoInterface.PresenterListado {

    private static MyPresenterListado presenter;

    public Intent lanzarFormulario(Context content){
        return new Intent(content, Formulario.class);
    }
    public Intent lanzarBusqueda(Context content){
        return new Intent(content, Busqueda.class);
    }
    public Intent lanzarSobreApp(Context content){
        return new Intent(content, SobreApp.class);
    }
    public static MyPresenterListado getInstance(){
        if (presenter == null){
            presenter = new MyPresenterListado();
        }
        return presenter;
    }
}
