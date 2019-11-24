package com.application.schoolmanagerapp.Presenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPresenterBusqueda {
    private static MyPresenterBusqueda presenter;

    public void buscar(){
        //Limpiar formulario, recoger todos los datos y guardar el nuevo contacto o dejarlo vacio para terminar actividad
    }
    public boolean validarFormulario(String campo, String valor){
        boolean isValid = false;
        Pattern pat;
        Matcher mat;
        switch (campo){
            case "nombre":
            case "apellidos":
                pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
                mat = pat.matcher(valor);
                if (mat.matches()) {
                    isValid = true;
                }
                break;
            case "email":
                pat = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
                mat = pat.matcher(valor);
                if (mat.matches()) {
                    isValid = true;
                }
                break;
            case "telefono":
                pat = Pattern.compile("^[9|6|7][0-9]{8}$");
                mat = pat.matcher(valor);
                if (mat.matches()) {
                    isValid = true;
                }
                break;
            case "fecha":
                pat = Pattern.compile("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$");
                mat = pat.matcher(valor);
                if (mat.matches()) {
                    isValid = true;
                }
                break;
        }

        return isValid;
    }
    public static MyPresenterBusqueda getInstance(){
        if (presenter == null){
            presenter = new MyPresenterBusqueda();
        }
        return presenter;
    }
}
