package com.example.healthyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "CREATE TABLE booklabtest(id INTEGER PRIMARY KEY AUTOINCREMENT, testname TEXT, date TEXT, patientname TEXT, contact TEXT)";
        sqLiteDatabase.execSQL(qry2);

        String qry3 = "CREATE TABLE appointments(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age TEXT, address TEXT, contact TEXT, doctor TEXT, date TEXT, time TEXT)";
        sqLiteDatabase.execSQL(qry3);

        String qry4 = "CREATE TABLE BuyMedicine(medicine string, name TEXT, price TEXT)";
        sqLiteDatabase.execSQL(qry4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username,String email,String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null,cv);
        db.close();

    }

    public int login(String username,String password){
        int result=0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }

    // Book Lab Test Method
    public void bookLabTest(String testName, String date, String patientName, String contact) {
        ContentValues cv = new ContentValues();
        cv.put("testname", testName);
        cv.put("date", date);
        cv.put("patientname", patientName);
        cv.put("contact", contact);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("booklabtest", null, cv);
        db.close();
    }

    public boolean updateLabTest(String testName, String date, String patientName, String contact) {
        ContentValues cv = new ContentValues();
        cv.put("testname", testName);
        cv.put("date", date);
        cv.put("contact", contact);

        SQLiteDatabase db = getWritableDatabase();
        int result = db.update("booklabtest", cv, "patientname = ?", new String[]{patientName});
        db.close();
        return result > 0;
    }

    public void bookAppointment(String name, String age, String address, String contact, String doctor, String date, String time) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        cv.put("address", address);
        cv.put("contact", contact);
        cv.put("doctor", doctor);
        cv.put("date", date);
        cv.put("time", time);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("appointments", null, cv);
        db.close();
    }





}
