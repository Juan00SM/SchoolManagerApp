package com.juansm.schoolmanager.Model.DAOs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.juansm.schoolmanager.Model.Database.DataBaseConnection;
import com.juansm.schoolmanager.Model.Entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private final String TAG = "SchoolManager/CourseDAO";
    private final String nameTable = "course";
    private static CourseDAO dao;

    public static CourseDAO getInstance() {
        if (dao == null) {
            dao = new CourseDAO();
        }
        return dao;
    }

    public CourseDAO() {
    }

    public boolean insertCourse(Course course) {
        boolean done = false;
        if (course != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("typeEducation", course.getTypeEducation());
                values.put("courseNumber", course.getCourseNumber());

                db.beginTransaction();
                try {
                    db.insertOrThrow(nameTable, null, values);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to add course to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public boolean modifyCourse(Course course) {
        boolean done = false;
        if (course != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("typeEducation", course.getTypeEducation());
                values.put("courseNumber", course.getCourseNumber());

                db.beginTransaction();
                try {
                    String[] args = new String[]{String.valueOf(course.getId())};
                    db.update(nameTable, values, "id=?", args);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to modify course to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public boolean removeCourse(Long id) {
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
                    Log.d(TAG, "Error while trying to remove course to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Course cs;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "typeEducation", "courseNumber"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        cs = new Course();

                        cs.setId(c.getLong(0));
                        cs.setTypeEducation(c.getString(1));
                        cs.setCourseNumber(c.getInt(2));

                        courses.add(cs);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to read course to database");
            } finally {
                db.close();
            }
        }
        return courses;
    }
}
