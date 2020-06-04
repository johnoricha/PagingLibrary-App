package com.practise.paginglibproject;


import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person_table")
    LiveData<List<Person>> getAll();

    @Query("SELECT * FROM person_table")
    DataSource.Factory<Integer, Person> getAllPaged();

    @Insert
    void insertAll(List<Person> persons);

    @Insert
    void insert(Person person);

    @Delete
    void deletePerson(Person person);
}
