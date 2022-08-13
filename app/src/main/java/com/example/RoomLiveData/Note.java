package com.example.RoomLiveData;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note
{
    @PrimaryKey (autoGenerate = true)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessgae() {
        return Messgae;
    }

    public void setMessgae(String messgae) {
        Messgae = messgae;
    }

    String Title;
    String Messgae;
}
