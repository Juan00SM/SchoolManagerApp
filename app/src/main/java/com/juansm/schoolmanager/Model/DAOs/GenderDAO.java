package com.juansm.schoolmanager.Model.DAOs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.juansm.schoolmanager.Model.Database.DataBaseConnection;
import com.juansm.schoolmanager.Model.Entities.Gender;

import java.util.ArrayList;
import java.util.List;

public class GenderDAO {

    private final String TAG = "SchoolManager/GenderDAO";
    private final String nameTable = "gender";
    private static GenderDAO dao;

    public static GenderDAO getInstance() {
        if (dao == null) {
            dao = new GenderDAO();
        }
        return dao;
    }

    public GenderDAO() {
    }

    public Long insertGender(Gender gender) {
        Long id = (long)-1;
        if (gender != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("name", gender.getName());
                values.put("description", gender.getDescription());


                db.beginTransaction();
                try {
                    id = db.insertOrThrow(nameTable, null, values);
                    db.setTransactionSuccessful();
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to add gender to database");
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return id;
    }

    public boolean modifyGender(Gender gender) {
        boolean done = false;
        if (gender != null) {
            DataBaseConnection dbConn = DataBaseConnection.getInstance();
            SQLiteDatabase db = dbConn.getWritableDatabase();
            ContentValues values = new ContentValues();

            if (db != null) {
                values.put("name", gender.getName());
                values.put("description", gender.getDescription());


                db.beginTransaction();
                try {
                    String[] args = new String[]{String.valueOf(gender.getId())};
                    db.update(nameTable, values, "id=?", args);
                    db.setTransactionSuccessful();
                    done = true;
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to modify gender to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public boolean removeGender(Long id) {
        boolean done = false;
        if (id != null){
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
                    Log.d(TAG, "Error while trying to remove gender to database");
                    done = false;
                } finally {
                    db.endTransaction();
                    db.close();
                }
            }
        }
        return done;
    }

    public List<Gender> getGenders() {
        List<Gender> genders = new ArrayList<>();
        Gender gd;
        DataBaseConnection dbConn = DataBaseConnection.getInstance();
        SQLiteDatabase db = dbConn.getReadableDatabase();
        Cursor c;
        String[] columns = new String[]{"id", "name", "description"};
        if (db != null) {

            try {
                c = db.query(nameTable, columns, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        gd = new Gender();

                        gd.setId(c.getLong(0));
                        gd.setName(c.getString(1));
                        gd.setDescription(c.getString(2));

                        genders.add(gd);
                    } while (c.moveToNext());
                }
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to read gender to database");
            } finally {
                db.close();
            }
        }
        Log.d(TAG, "Hay tantos generos: "+genders.size());
        return genders;
    }
}
