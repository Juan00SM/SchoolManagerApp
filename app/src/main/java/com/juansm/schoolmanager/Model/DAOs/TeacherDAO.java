package com.juansm.schoolmanager.Model.DAOs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.material.textfield.TextInputLayout;
import com.juansm.schoolmanager.Model.Database.DataBaseConnection;
import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    private final String TAG = "SchoolManager/TeacheDAO";
    private final String nameTable = "teacher";
    private static TeacherDAO dao;

    public static TeacherDAO getInstance() {
        if (dao == null) {
            dao = new TeacherDAO();
        }
        return dao;
    }

    public TeacherDAO() {
    }

    public boolean insertTeacher(Teacher teacher) {
        boolean done = false;
        if (teacher != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("name", teacher.getName());
                values.put("lastName", teacher.getLastName());
                values.put("phone", teacher.getPhone());
                values.put("email", teacher.getEmail());
                values.put("birthDate", teacher.getBirthDate());
                values.put("address", teacher.getAddress());
                values.put("idGender", teacher.getIdGender());
                values.put("communicationDay", teacher.getCommunicationDay());
                values.put("communicationHour", teacher.getCommunicationHour());
                values.put("isTutor", teacher.getIsTutor());
                values.put("img", teacher.getImg());

                db.beginTransaction();
                try {
                    db.insertOrThrow(nameTable, null, values);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to add teacher to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public boolean modifyTeacher(Teacher teacher) {
        boolean done = false;
        if (teacher != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("name", teacher.getName());
                values.put("lastName", teacher.getLastName());
                values.put("phone", teacher.getPhone());
                values.put("email", teacher.getEmail());
                values.put("birthDate", teacher.getBirthDate());
                values.put("address", teacher.getAddress());
                values.put("idGender", teacher.getIdGender());
                values.put("communicationDay", teacher.getCommunicationDay());
                values.put("communicationHour", teacher.getCommunicationHour());
                values.put("isTutor", teacher.getIsTutor());
                values.put("img", teacher.getImg());

                db.beginTransaction();
                try {
                    String[] args = new String[]{String.valueOf(teacher.getId())};
                    db.update(nameTable, values, "id=?", args);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to modify teacher to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public boolean removeTeacher(Long id) {
        boolean done = false;
        if (id != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();

            if (db != null) {

                db.beginTransaction();
                try {
                    String[] args = new String[]{String.valueOf(id)};
                    db.delete(nameTable, "id=?", args);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to remove teacher to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher tc;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "lastName", "phone", "email", "birthDate", "address", "idGender", "communicationDay",
                "communicationHour", "isTutor", "img"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        tc = new Teacher();

                        tc.setId(c.getLong(0));
                        tc.setName(c.getString(1));
                        tc.setLastName(c.getString(2));
                        tc.setPhone(c.getString(3));
                        tc.setEmail(c.getString(4));
                        tc.setBirthDate(c.getString(5));
                        tc.setAddress(c.getString(6));
                        tc.setIdGender(c.getLong(7));
                        tc.setCommunicationDay(c.getString(8));
                        tc.setCommunicationHour(c.getString(9));
                        tc.setIsTutor(c.getInt(10));
                        tc.setImg(c.getString(11));

                        teachers.add(tc);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to read teacher to database");
            } finally {
                db.close();
            }
        }
        return teachers;
    }

    public List<Teacher> getTeachersReduced() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher tc;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "phone", "img"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        tc = new Teacher();

                        tc.setId(c.getLong(0));
                        tc.setName(c.getString(1));
                        tc.setPhone(c.getString(2));
                        tc.setImg(c.getString(3));

                        teachers.add(tc);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to read teacher to database");
            } finally {
                db.close();
            }
        }
        return teachers;
    }

    public Teacher getTeacherById(Long id) {
        Teacher tc = null;
        if (id != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getReadableDatabase();
            Cursor c;
            String[] columns = new String[]{"id", "name", "lastName", "phone", "email", "birthDate", "address", "idGender", "communicationDay",
                    "communicationHour", "isTutor", "img"};
            String selection = "id=?";
            String[] args = new String[]{String.valueOf(id)};
            if (db != null) {

                try {
                    c = db.query(nameTable, columns, selection, args, null, null, null);

                    if (c.moveToFirst()) {
                        tc = new Teacher();

                        tc.setId(c.getLong(0));
                        tc.setName(c.getString(1));
                        tc.setLastName(c.getString(2));
                        tc.setPhone(c.getString(3));
                        tc.setEmail(c.getString(4));
                        tc.setBirthDate(c.getString(5));
                        tc.setAddress(c.getString(6));
                        tc.setIdGender(c.getLong(7));
                        tc.setCommunicationDay(c.getString(8));
                        tc.setCommunicationHour(c.getString(9));
                        tc.setIsTutor(c.getInt(10));
                        tc.setImg(c.getString(11));
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to read teacher to database");
                } finally {
                    db.close();
                }
            }
        }
        return tc;
    }
}
