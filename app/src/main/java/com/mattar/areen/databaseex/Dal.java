package com.mattar.areen.databaseex;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "myDbContacts.db", null, 1);
    }
    public void addContact(String name,String email,String phone){
        SQLiteDatabase db=getWritableDatabase();
        String sqlInsert="INSERT INTO CONTACTS (name,email,phone) values(?,?,?)";
        SQLiteStatement statement=db.compileStatement(sqlInsert);
        statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,phone);
        statement.execute();
    }
    public void addContactWithImage(String name,String email,String phone,byte[] img){
        SQLiteDatabase db=getWritableDatabase();
        String sqlInsert="INSERT INTO CONTACTS (name,email,phone) values(?,?,?)";
        SQLiteStatement statement=db.compileStatement(sqlInsert);
        statement.bindString(1,name);
        statement.bindString(2,email);
        statement.bindString(3,phone);
        statement.bindBlob(6,img);
        statement.execute();
    }
    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> ary=new ArrayList<>();
        String st="select * from contacts";
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(st,null);
        while (cursor.moveToNext()){
            Contact c=new Contact();
            c.setName(cursor.getString(cursor.getColumnIndex("name")));
            c.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            c.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            c.setContactImage(cursor.getBlob(cursor.getColumnIndex("img")));
            ary.add(c);
        }
        return  ary;
    }
}
