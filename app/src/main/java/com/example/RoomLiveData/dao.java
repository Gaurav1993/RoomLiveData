package com.example.RoomLiveData;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import androidx.room.Dao;
@Dao
public interface dao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void  insert(Note note);

    @Query("SELECT * from note")
    LiveData<List<Note>> getListOfnote();

    @Update
    public void update(Note note);


    @Query("DELETE FROM note WHERE id = id")
    public void delete();
}
