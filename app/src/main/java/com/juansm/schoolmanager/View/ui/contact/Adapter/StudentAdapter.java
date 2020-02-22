package com.juansm.schoolmanager.View.ui.contact.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juansm.schoolmanager.Model.Entities.Student;
import com.juansm.schoolmanager.R;
import com.juansm.schoolmanager.TheApplication;
import com.juansm.schoolmanager.View.ui.contact.Fragment.FormStudent;
import com.juansm.schoolmanager.View.ui.contact.Fragment.ContactsFragment;
import com.juansm.schoolmanager.View.ui.contact.Fragment.StudentFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> implements View.OnClickListener {

    String TAG = "SchoolManager/Adapters/StudentAdapter";
    private List<Student> students;
    private View.OnClickListener listener;

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        //variables del cardview
        CircleImageView img;
        TextView name;
        TextView phone;

        public StudentViewHolder(@NonNull View itemView) {
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

    public StudentAdapter() {

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        if (students != null) {
            this.students = students;
        } else {
            this.students = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public boolean removeItem(int position) {
        this.students.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    public boolean addItem(Student student) {
        this.students.add(student);
        notifyItemInserted(this.students.size() - 1);
        return true;
    }

    public boolean changeItem(int position, Student student) {
        this.students.set(position, student);
        notifyItemChanged(position);
        return true;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "Ejecutando onCreateViewHolder...");

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cardview, parent, false);
        v.setOnClickListener(this);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder viewHolder, int position) {
        Log.d(TAG, "Ejecutando onBindViewHolder...");
        //setear campos del layout cardview
        Student student = this.students.get(position);

        if (student.getImg() != null && !student.getImg().equals("")) {
            byte[] decodedImg = Base64.decode(student.getImg(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedImg, 0, decodedImg.length);

            viewHolder.getImg().setImageBitmap(bitmap);
        }

        viewHolder.getName().setText(student.getName());
        viewHolder.getPhone().setText(student.getPhone());
    }

    @Override
    public int getItemCount() {
        return this.students.size();
    }

    @Override
    public long getItemId(int position) {
        return this.students.get(position).getId();
    }

    @Override
    public void onClick(View v) {
        if(this.listener != null){
            this.listener.onClick(v);
        }
    }

    public void setNewOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}