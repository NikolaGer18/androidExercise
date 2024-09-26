package com.example.news;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder  extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView author;
    private TextView reference;

    public DataHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.textView);
        author = itemView.findViewById(R.id.textView2);
        reference = itemView.findViewById(R.id.textView3);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public void setReference(String reference) {
        this.reference.setText(reference);
    }
}
