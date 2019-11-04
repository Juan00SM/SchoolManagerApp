package com.application.schoolmanagerapp.Interfaces;


public interface ListadoInterface {
    interface View {
        void lanzarFormulario();
    }
    interface ViewFormulario {
        void terminarFormulario();
    }

    interface Presenter{
        void onClickAdd();
    }
}

