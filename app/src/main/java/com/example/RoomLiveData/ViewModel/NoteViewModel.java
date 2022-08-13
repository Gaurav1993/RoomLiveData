package com.example.RoomLiveData.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.RoomLiveData.Note;
import com.example.RoomLiveData.repositry.NoteRepo;

import java.util.List;

public class NoteViewModel extends AndroidViewModel
{
    public NoteRepo mvvmrepositry;
    public  LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application)
    {
        super(application);
        mvvmrepositry = new NoteRepo(application);
        allNotes = mvvmrepositry.getAllNotes();
    }

    public void insert(Note note) {
        mvvmrepositry.insert(note);
    }
    public void update(Note note) {
        mvvmrepositry.update(note);
    }
//    public void delete(Note note) {
//        mvvmrepositry.(note);
//    }
//    public void deleteAllNotes() {
//        mvvmrepositry.deleteAllNotes();
//    }
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }


}
