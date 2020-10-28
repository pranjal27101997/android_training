package com.example.crud_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname="mydb";
    private static final int version=1;
    public MyHelper(Context context) {
        super(context, dbname,null,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE PRODUCTS(_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT ,DESCRIPTION TEXT ,PRICE REAL)";
        db.execSQL(sql);

        insertData("james ","fruit jam ",300,db);
        insertData("bread ","brown bread ",30,db);
        insertData("cornflakes ","flakes ",100,db);
        insertData("apple ","fruit ",500,db);
        insertData("onion "," vegetable ",310,db);
        insertData("pizza ","fastfood ",1100,db);


    }
    public void insertData(String name, String description , double price ,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);
        database.insert("PRODUCTS",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
