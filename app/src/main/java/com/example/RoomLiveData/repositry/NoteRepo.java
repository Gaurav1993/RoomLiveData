package com.example.RoomLiveData.repositry;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.RoomLiveData.Note;
import com.example.RoomLiveData.NoteDataBase;
import com.example.RoomLiveData.dao;

import java.util.List;

public class NoteRepo
{


    public LiveData<List<Note>> mutableLiveData;
    private dao noteDao;


    public NoteRepo(Application application) {
        NoteDataBase database = NoteDataBase.getInstance(application);
        noteDao = database.getNoteDao();
        mutableLiveData = noteDao.getListOfnote();
    }


    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public LiveData<List<Note>> getAllNotes() {
        return mutableLiveData;
    }
    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private dao noteDao;
        private InsertNoteAsyncTask(dao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private dao noteDao;
        private UpdateNoteAsyncTask(dao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
}
