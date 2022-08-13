package com.example.RoomLiveData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.RoomLiveData.ViewModel.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    NoteViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        Note note=new Note();
        note.setTitle("Paper");
        note.setMessgae("Today Paper");

        noteViewModel.insert(note);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) { //called every time data changes
            String Message=noteViewModel.getAllNotes().getValue().get(0).getMessgae();
                Log.d("Message",Message);
            }
        });

     //   noteViewModel.update(items);
    }
}