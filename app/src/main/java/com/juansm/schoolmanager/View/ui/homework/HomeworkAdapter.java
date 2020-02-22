package com.juansm.schoolmanager.View.ui.homework;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juansm.schoolmanager.Model.Entities.Homework;
import com.juansm.schoolmanager.R;

import java.util.ArrayList;
import java.util.List;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.HomeworkViewHolder> {

    String TAG = "SchoolManager/Adapters/HomeworkAdapter";
    private List<Homework> homeworks;

    public class HomeworkViewHolder extends RecyclerView.ViewHolder{
        //variables del cardview
        TextView date;
        TextView subject;
        TextView matter;

        public HomeworkViewHolder(@NonNull View itemView) {
            super(itemView);

            this.date = itemView.findViewById(R.id.label_card_homework_date);
            this.subject = itemView.findViewById(R.id.label_card_homework_subject);
            this.matter = itemView.findViewById(R.id.label_card_homework_matter);
        }

        public TextView getDate() {
            return date;
        }

        public TextView getSubject() {
            return subject;
        }

        public TextView getMatter() {
            return matter;
        }
    }

    public HomeworkAdapter(List<Homework> homeworks) {
        this.setHomeworks(homeworks);
    }

    public List<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<Homework> homeworks) {
        if (homeworks!=null) {
            this.homeworks = homeworks;
        }else{
            this.homeworks = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public HomeworkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Ejecutando onCreateViewHolder...");

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homework_cardview, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new HomeworkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeworkViewHolder viewHolder, int position) {
        Log.d(TAG, "Ejecutando onBindViewHolder...");
        //setear campos del layout cardview
        Homework homework = this.homeworks.get(position);

        //BUSCAR EN LA BASE DE DATOS LA ASIGNATURA PARA EL TITULO
        Long idSubject = homework.getIdSubject();
        viewHolder.getSubject().setText("ViewHolder Asignatura");
        viewHolder.getMatter().setText(homework.getMatter());
        viewHolder.getDate().setText(homework.getDeliveryDate());

    }

    @Override
    public int getItemCount() {
        return this.homeworks.size();
    }
}
