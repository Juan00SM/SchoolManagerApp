package com.application.schoolmanagerapp.Presenter;

import android.content.Intent;

import com.application.schoolmanagerapp.Interfaces.ListadoInterface;
import com.application.schoolmanagerapp.View.Formulario;
import com.application.schoolmanagerapp.View.ListaContactos;

public class MyPresenterListado implements ListadoInterface.Presenter {

    private static MyPresenterListado presenter;

    public void onClickAdd(){
        ListaContactos.setFormulario(new Intent(ListaContactos.getContent(), Formulario.class));
    }
    public static MyPresenterListado getInstance(){
        if (presenter == null){
            presenter = new MyPresenterListado();
        }
        return presenter;
    }
}
