package com.example.whatsapp;

import android.media.Image;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String body;
    private double msgDate;
    private String name;
   @Ignore
    private Image personalimage;
   @Ignore
    private String lastmsg;

    public String getName() {
        return name;
    }

   // public Image getPersonalimage() {
     //   return personalimage;
    //}

    //public String getLastmsg() {
      //  return lastmsg;
    //}


    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public double getMsgDate() {
        return msgDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note(String body, double msgDate, String name) {
        this.body = body;
        this.msgDate = msgDate;
        this.name = name;
      //  this.personalimage = personalimage;
       // this.lastmsg = lastmsg;
    }
}
