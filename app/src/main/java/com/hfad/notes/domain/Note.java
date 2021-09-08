package com.hfad.notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private final int id;
    private final String date;
    private final String title;
    private final String body;

    public Note(int id, String date, String title, String body) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    protected Note(Parcel in) {
        id = in.readInt();
        date = in.readString();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(date);
        parcel.writeString(title);
        parcel.writeString(body);
    }
}
