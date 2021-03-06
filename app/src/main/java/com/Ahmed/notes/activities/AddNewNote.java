package com.Ahmed.notes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.omar98K.notes.R;
import com.Ahmed.notes.classes.Note;
import java.util.Date;
public class AddNewNote extends AppCompatActivity {
    EditText title,contextDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);
        title=(findViewById(R.id.edit_text_note_name));
        contextDes=findViewById(R.id.edit_text_note_description);
   }


    public void backFromAddNewActivity(View view) {
        finish();
    }

    public void OnClickAdd(View view) {

        Note note=new Note(Home_Page.currentNotebookId,Note.generateNoteID(),title.getText().toString(),contextDes.getText().toString(),new Date().getTime());
        Home_Page.writeNote(note);
        Toast.makeText(this,"Note is added successfully" , Toast.LENGTH_SHORT).show();

        finish();
    }
}