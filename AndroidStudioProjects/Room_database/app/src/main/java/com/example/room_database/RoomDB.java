package com.example.room_database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//database entities add kro
@Database(entities ={MainData.class},version =1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {


    //database instance bnao
    private static RoomDB database;

    //database ka naam
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context) {

        //condition chk kro
        if (database == null) {
            //database initialize
            database = Room.databaseBuilder(context.getApplicationContext()
                    , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //database return kro
        return database;
    }
    //create Dao
    public abstract MainDao mainDao();
}
