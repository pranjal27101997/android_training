package com.example.room_database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

    //insert krna
    @Insert(onConflict = REPLACE)
    void insert(MainData maindata);

    @Delete
    void delete(MainData mainData);

    // delete all krna

    @Delete
    void reset(List<MainData> mainData);

    //update kro

    @Query("UPDATE tablename SET text = :sText WHERE ID = :sID")
    void update(int sID,String sText);

    //get all data query database se

    @Query("SELECT * FROM tablename")
    List<MainData> getAll();


}
