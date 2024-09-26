package com.example.news;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class News implements Parcelable {
    private String title;
    private String author;
    private String reference;
    private String text;

    protected News(Parcel in) {
        title = in.readString();
        author = in.readString();
        reference = in.readString();
        text = in.readString();
    }


    public News(String title, String author, String reference, String text) {
        this.title = title;
        this.author = author;
        this.reference = reference;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(reference);
        parcel.writeString(text);
    }
}
