package com.juansm.schoolmanager.View.ui.contact.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juansm.schoolmanager.Model.Entities.Teacher;
import com.juansm.schoolmanager.R;
import com.juansm.schoolmanager.View.ui.contact.Adapter.TeacherAdapter;
import com.juansm.schoolmanager.View.ui.contact.ContactsViewModel;


import java.util.List;

public class TeacherFragment extends Fragment {

    String TAG = "SchoolManager/Fragments/TeacherFragment";
    private ContactsViewModel contactsViewModel;
    private TeacherAdapter teacherAdapter;
    private TextView countTeacher;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "Entrando en onCreateView...");

        View root = inflater.inflate(R.layout.fragment_contacts_teacher, container, false);

        this.recyclerView = root.findViewById(R.id.recyclerview_teacher);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        this.countTeacher = root.findViewById(R.id.countTeacher);

        this.teacherAdapter = new TeacherAdapter();
        this.recyclerView.setAdapter(this.teacherAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Entrando en onActivityCreated...");

        contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel.class);
        contactsViewModel.getTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teacher>>() {
            @Override
            public void onChanged(@Nullable List<Teacher> list) {
                teacherAdapter.setTeachers(list);
                String text;
                if (list!=null){
                    text = list.size()+getString(R.string.label_countListTeacher);
                }else{
                    text = getString(R.string.label_countListTeacher);
                }
                countTeacher.setText(text);
            }
        });
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
