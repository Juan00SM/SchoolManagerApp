package com.application.schoolmanagerapp.View.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.schoolmanagerapp.Model.Persona;
import com.application.schoolmanagerapp.R;
import com.application.schoolmanagerapp.View.AdaptadorPersona;
import com.application.schoolmanagerapp.View.ListaContactos;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerpersonas);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(ListaContactos.getContent());
        TextView textcontador = (TextView) root.findViewById(R.id.textcontador);
        textcontador.setText((Persona.personas.size()+" resultados encontrados"));

        recyclerView.setLayoutManager(layoutmanager);

        AdaptadorPersona adaptador = new AdaptadorPersona();
        recyclerView.setAdapter(adaptador);
        return root;
    }
}