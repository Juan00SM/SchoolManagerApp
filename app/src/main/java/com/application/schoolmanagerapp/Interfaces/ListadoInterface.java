package com.application.schoolmanagerapp.Interfaces;


import android.content.Context;
import android.content.Intent;

public interface ListadoInterface {
    interface View {
        void llamarFormulario();
    }
    interface ViewFormulario {
        void terminarFormulario();
    }

    interface PresenterListado{
        Intent lanzarFormulario(Context content);
    }
    interface PresenterFormulario{
        void guardarNuevo();
        void cancelarNuevo();
    }
}

