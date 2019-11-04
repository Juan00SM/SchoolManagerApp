package com.application.schoolmanagerapp.Presenter;

import android.content.Intent;

import com.application.schoolmanagerapp.Interfaces.ListadoInterface;
import com.application.schoolmanagerapp.View.Formulario;
import com.application.schoolmanagerapp.View.ListaContactos;

public class MyPresenterFormulario implements ListadoInterface.Presenter {
    private static MyPresenterListado presenter;

    public void onClickAdd(){
        //Limpiar formulario, recoger todos los datos y guardar el nuevo contacto o dejarlo vacio para terminar actividad
    }
    public static MyPresenterListado getInstance(){
        if (presenter == null){
            presenter = new MyPresenterListado();
        }
        return presenter;
    }
}
