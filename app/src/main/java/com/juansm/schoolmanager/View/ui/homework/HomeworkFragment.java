package com.juansm.schoolmanager.View.ui.homework;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juansm.schoolmanager.Model.Entities.Homework;
import com.juansm.schoolmanager.R;

import java.util.ArrayList;

public class HomeworkFragment extends Fragment {

    String TAG = "SchoolManager/Fragments/HomeworkFragment";
    private HomeViewModel homeViewModel;
    private HomeworkAdapter homeworkAdapter;
    private TextView countHomework;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "Entrando en onCreateView...");

        View root = inflater.inflate(R.layout.fragment_homeworks, container, false);

        this.recyclerView = root.findViewById(R.id.recyclerview_homework);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        this.countHomework = root.findViewById(R.id.countHomework);

        //Long id, Long idSubject, String matter, String description, Date deliveryDate
        ArrayList<Homework> hom = new ArrayList<>();
        {
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
            hom.add(new Homework((long) 1, (long) 1, "ejemplo", "descripcion de ejemplo", "27/02/2020"));
        }

        this.homeworkAdapter = new HomeworkAdapter(hom);
        this.recyclerView.setAdapter(this.homeworkAdapter);

        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Entrando en onActivityCreated...");

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
        homeViewModel.getCountHomeworks().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer c) {
                String text = c+" "+getString(R.string.label_countListHomework);
                countHomework.setText(text);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        Log.d(TAG, "Entrando en onCreateOptionsMenu...");

        menu.clear();
        inflater.inflate(R.menu.options_homeworks_menu,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Log.d(TAG, "Entrando en onOptionsItemSelected...");

        switch (item.getItemId()){
            case R.id.menu_edit_timetable:
                Log.d("juan", "edit");
                return true;
            case R.id.menu_search_homework:
                Log.d("juan", "search");
                return true;
            case R.id.menu_help_homework:
                Log.d("juan", "help");
                return true;
            case R.id.menu_about:
                Log.d("juan", "about");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }
}