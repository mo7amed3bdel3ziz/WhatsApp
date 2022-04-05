package com.example;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase Instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "Note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return Instance;

    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull  SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDBAsyncTask(Instance).execute();
        }
    };

    private static class populateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private populateDBAsyncTask(NoteDatabase db) {
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("title1", 11.11, "name1"));
            noteDao.insert(new Note("title2", 11.12, "name2"));
            noteDao.insert(new Note("title3", 11.13, "name3"));

            return null;
        }
    }
}
