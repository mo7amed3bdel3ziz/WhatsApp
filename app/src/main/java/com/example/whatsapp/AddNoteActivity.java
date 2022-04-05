package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.jar.Attributes;

public class AddNoteActivity extends AppCompatActivity {
    private static final String TAG = "GGGGGG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 2");
        setContentView(R.layout.activity_add_note);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_backspace);
        setTitle("Search Note");
    }
    private void searchNote(){
        Toast.makeText(this, "search in WhatsApp numbers", Toast.LENGTH_SHORT).show();
            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_note:
                searchNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}