package com.juansm.schoolmanager.Model.DAOs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.juansm.schoolmanager.Model.Database.DataBaseConnection;
import com.juansm.schoolmanager.Model.Entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final String TAG = "SchoolManager/StudenDAO";
    private final String nameTable = "student";
    private static StudentDAO dao;

    public static StudentDAO getInstance() {
        if (dao == null) {
            dao = new StudentDAO();
        }
        return dao;
    }

    public StudentDAO() {
    }

    public Long insertStudent(Student student) {
        Long id = (long)-1;
        if (student != null) {
            if (student.isValid()){
                DataBaseConnection dbConn = DataBaseConnection.getInstance();
                SQLiteDatabase db = dbConn.getWritableDatabase();
                ContentValues values = new ContentValues();

                if (db != null) {
                    values.put("name", student.getName());
                    values.put("lastName", student.getLastName());
                    values.put("phone", student.getPhone());
                    values.put("email", student.getEmail());
                    values.put("nameFather", student.getNameFather());
                    values.put("nameMother", student.getNameMother());
                    values.put("fatherPhone", student.getFatherPhone());
                    values.put("motherPhone", student.getMotherPhone());
                    values.put("birthDate", student.getBirthDate());
                    values.put("idCourse", student.getIdCourse());
                    values.put("address", student.getAddress());
                    values.put("idGender", student.getIdGender());
                    values.put("img", student.getImg());


                    db.beginTransaction();
                    try {
                        id = db.insertOrThrow(nameTable, null, values);
                        db.setTransactionSuccessful();
                    } catch (Exception e) {
                        Log.d(TAG, "Error while trying to add student to database");
                    } finally {
                        db.endTransaction();
                        db.close();
                    }
                }
            }
        }
        return id;
    }

    public boolean modifyStudent(Student student) {
        boolean done = false;
        if (student != null) {
            if (student.getId()!=null){
                DataBaseConnection dbConn = DataBaseConnection.getInstance();
                SQLiteDatabase db = dbConn.getWritableDatabase();
                ContentValues values = new ContentValues();

                if (db != null) {
                    values.put("name", student.getName());
                    values.put("lastName", student.getLastName());
                    values.put("phone", student.getPhone());
                    values.put("email", student.getEmail());
                    values.put("nameFather", student.getNameFather());
                    values.put("nameMother", student.getNameMother());
                    values.put("fatherPhone", student.getFatherPhone());
                    values.put("motherPhone", student.getMotherPhone());
                    values.put("birthDate", student.getBirthDate());
                    values.put("idCourse", student.getIdCourse());
                    values.put("address", student.getAddress());
                    values.put("idGender", student.getIdGender());
                    values.put("img", student.getImg());


                    db.beginTransaction();
                    try {
                        Log.d(TAG, "UPDATEEEE");
                        String[] args = new String[]{String.valueOf(student.getId())};
                        db.update(nameTable, values, "id=?", args);
                        db.setTransactionSuccessful();
                        done = true;
                    } catch (Exception e) {
                        Log.d(TAG, "Error while trying to modify student to database");
                        done = false;
                    } finally {
                        db.endTransaction();
                        db.close();
                    }
                }
            }
        }
        return done;
    }

    public boolean removeStudent(Long id) {
        boolean done = false;
        if (id != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();

            if (db != null) {

                db.beginTransaction();
                try {
                    String[] args = new String[]{String.valueOf(id)};
                    int count = db.delete(nameTable, "id=?", args);
                    db.setTransactionSuccessful();
                    if (count>0){
                        done = true;
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to remove student to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student st;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "lastName", "phone", "email", "nameFather", "nameMother", "fatherPhone", "motherPhone",
                "birthDate", "idCourse", "address", "idGender", "img"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        st = new Student();
                        Log.d(TAG, "Estudiante creado");
                        st.setId(c.getLong(0));
                        st.setName(c.getString(1));
                        st.setLastName(c.getString(2));
                        st.setPhone(c.getString(3));
                        st.setEmail(c.getString(4));
                        st.setNameFather(c.getString(5));
                        st.setNameMother(c.getString(6));
                        st.setFatherPhone(c.getString(7));
                        st.setMotherPhone(c.getString(8));
                        st.setBirthDate(c.getString(9));
                        st.setIdCourse(c.getLong(10));
                        st.setAddress(c.getString(11));
                        st.setIdGender(c.getLong(12));
                        st.setImg(c.getString(13));

                        students.add(st);
                        Log.d(TAG, "Estudiante añadido");
                    } while (c.moveToNext());
                }
            } catch (Exception e) {

                Log.d(TAG, "Error while trying to read student to database" + e.getLocalizedMessage() + e.getMessage());
            } finally {
                db.close();
            }
        }
        return students;
    }

    public List<Student> getStudentsReduced() {
        List<Student> students = new ArrayList<>();
        Student st;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "phone", "img"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        st = new Student();
                        st.setId(c.getLong(0));
                        st.setName(c.getString(1));
                        st.setPhone(c.getString(2));
                        st.setImg(c.getString(3));

                        students.add(st);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {

                Log.d(TAG, "Error while trying to read student to database" + e.getLocalizedMessage() + e.getMessage());
            } finally {
                db.close();
            }
        }
        return students;
    }

    public Student getStudentById(Long id) {
        Student st = null;
        if (id != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getReadableDatabase();
            Cursor c;
            String[] columns = new String[]{"id", "name", "lastName", "phone", "email", "nameFather", "nameMother", "fatherPhone", "motherPhone",
                    "birthDate", "idCourse", "address", "idGender", "img"};
            String selection = "id=?";
            String[] args = new String[]{String.valueOf(id)};

            if (db != null) {

                try {
                    c = db.query(nameTable, columns, selection, args, null, null, null);

                    if (c.moveToFirst()) {
                        st = new Student();
                        st.setId(c.getLong(0));
                        st.setName(c.getString(1));
                        st.setLastName(c.getString(2));
                        st.setPhone(c.getString(3));
                        st.setEmail(c.getString(4));
                        st.setNameFather(c.getString(5));
                        st.setNameMother(c.getString(6));
                        st.setFatherPhone(c.getString(7));
                        st.setMotherPhone(c.getString(8));
                        st.setBirthDate(c.getString(9));
                        st.setIdCourse(c.getLong(10));
                        st.setAddress(c.getString(11));
                        st.setIdGender(c.getLong(12));
                        st.setImg(c.getString(13));
                    }
                } catch (Exception e) {

                    Log.d(TAG, "Error while trying to read student to database" + e.getLocalizedMessage() + e.getMessage());
                } finally {
                    db.close();
                }
            }
        }

        return st;
    }

    public List<Student> getStudentsByCriteriaReduced(String nameOrPhone, String date, Long idGender) {
        List<Student> students = new ArrayList<>();
        Student st;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "phone", "img"};

        String selection = "";
        selection += nameOrPhone!=null&&!nameOrPhone.equals("")?"(name like '%"+nameOrPhone+"%' or phone like '%"+nameOrPhone+"%')":"";
        String queryDate = date!=null&&!date.equals("")?"(birthDate like '%"+date+"%')":"";
        selection += !queryDate.equals("")?(!selection.equals("")?" and "+queryDate:queryDate):"";
        String queryIdGender = idGender!=null&&idGender>-1?"idGender = "+idGender:"";
        selection += !queryIdGender.equals("")?(!selection.equals("")?" and "+queryIdGender:queryIdGender):"";

        if (db != null) {

            try {
                c = db.query(nameTable, columns, selection, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        st = new Student();
                        st.setId(c.getLong(0));
                        st.setName(c.getString(1));
                        st.setPhone(c.getString(2));
                        st.setImg(c.getString(3));

                        students.add(st);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {

                Log.d(TAG, "Error while trying to read student to database" + e.getLocalizedMessage() + e.getMessage());
            } finally {
                db.close();
            }
        }
        return students;
    }
}