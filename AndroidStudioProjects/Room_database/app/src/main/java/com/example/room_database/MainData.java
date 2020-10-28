package com.example.room_database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//table name define kro
@Entity(tableName = "tablename")

public class MainData implements Serializable {
    //id column bnao

    @PrimaryKey(autoGenerate = true)
    private int ID;

    //text column bnao

    @ColumnInfo(name = "text")
    private String text;

    //getter and setter


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
