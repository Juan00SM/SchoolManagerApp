package com.juansm.schoolmanager.View.ui.contact;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juansm.schoolmanager.Model.DAOs.StudentDAO;
import com.juansm.schoolmanager.Model.DAOs.TeacherDAO;
import com.juansm.schoolmanager.Model.Entities.Gender;
import com.juansm.schoolmanager.Model.Entities.Student;
import com.juansm.schoolmanager.Model.Entities.Teacher;
import com.juansm.schoolmanager.Presenter.GenderPresenter;
import com.juansm.schoolmanager.Presenter.StudentPresenter;
import com.juansm.schoolmanager.Presenter.TeacherPresenter;

import java.util.List;

public class ContactsViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<List<Student>> students;
    private MutableLiveData<List<Teacher>> teachers;

    public ContactsViewModel() {

        this.students = new MutableLiveData<>();
        this.students.setValue(StudentPresenter.getInstance().readStudentsReduced());

        this.teachers = new MutableLiveData<>();
        this.teachers.setValue(TeacherPresenter.getInstance().readTeachersReduced());

    }

    public MutableLiveData<List<Teacher>> getTeachers() {
        return teachers;
    }

    public boolean setTeachers(List<Teacher> teachers) {
        this.teachers.setValue(teachers);
        return true;
    }

    public MutableLiveData<List<Student>> getStudents() {
        return students;
    }

    public boolean setStudents(List<Student> students) {
        this.students.setValue(students);
        return true;
    }

    public boolean removeStudent(int position){
        List<Student> list = this.students.getValue();
        list.remove(position);
        return this.setStudents(list);
    }

    public boolean addStudent(Student student){
        List<Student> list = this.students.getValue();
        list.add(student);
        return this.setStudents(list);
    }

    public boolean changeStudent(int position, Student student){
        List<Student> list = this.students.getValue();
        list.set(position,student);
        return this.setStudents(list);
    }
    public boolean removeTeacher(int position){
        List<Teacher> list = this.teachers.getValue();
        list.remove(position);
        return this.setTeachers(list);
    }

    public boolean addTeacher(Teacher teacher){
        List<Teacher> list = this.teachers.getValue();
        list.add(teacher);
        return this.setTeachers(list);
    }

    public boolean changeTeacher(int position, Teacher teacher){
        List<Teacher> list = this.teachers.getValue();
        list.set(position,teacher);
        return this.setTeachers(list);
    }
}
