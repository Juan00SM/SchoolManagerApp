package com.juansm.schoolmanager.View.ui.contact.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juansm.schoolmanager.Model.Entities.Teacher;
import com.juansm.schoolmanager.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    String TAG = "SchoolManager/Adapters/TeacherAdapter";
    private List<Teacher> teachers;

    public class TeacherViewHolder extends RecyclerView.ViewHolder{
        //variables del cardview
        CircleImageView img;
        TextView name;
        TextView phone;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);

            this.img = itemView.findViewById(R.id.image_card_contact);
            this.name = itemView.findViewById(R.id.label_card_contact_name);
            this.phone = itemView.findViewById(R.id.label_card_contact_phone);
        }

        public CircleImageView getImg() {
            return img;
        }

        public TextView getName() {
            return name;
        }

        public TextView getPhone() {
            return phone;
        }
    }

    public TeacherAdapter() {

    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public boolean setTeachers(List<Teacher> teachers) {
        if (teachers!=null) {
            this.teachers = teachers;
        }else{
            this.teachers = new ArrayList<>();
        }
        notifyDataSetChanged();
        return true;
    }

    public boolean removeItem(int position){
        this.teachers.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    public boolean addItem(Teacher teacher){
        this.teachers.add(teacher);
        notifyItemInserted(this.teachers.size()-1);
        return true;
    }

    public boolean changeItem(int position, Teacher teacher){
        this.teachers.set(position,teacher);
        notifyItemChanged(position);
        return true;
    }


    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Ejecutando onCreateViewHolder...");

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cardview, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new TeacherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder viewHolder, int position) {
        Log.d(TAG, "Ejecutando onBindViewHolder...");
        //setear campos del layout cardview
        Teacher teacher = this.teachers.get(position);

        if (teacher.getImg()!=null && !teacher.getImg().equals("")){
            byte[] decodedImg = Base64.decode(teacher.getImg(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedImg, 0, decodedImg.length);

            viewHolder.getImg().setImageBitmap(bitmap);
        }
        viewHolder.getName().setText(teacher.getName());
        viewHolder.getPhone().setText(teacher.getPhone());
    }

    @Override
    public int getItemCount() {
        return this.teachers.size();
    }
}
