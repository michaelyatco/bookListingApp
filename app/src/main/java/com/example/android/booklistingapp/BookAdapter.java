package com.example.android.booklistingapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mjyatco on 8/14/17.
 */

public class BookAdapter extends ArrayAdapter<BookObject> {

    public BookAdapter(Activity context, ArrayList<BookObject> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookObject book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        TextView miwokTextView = (TextView) convertView.findViewById(R.id.title_text_view);
        miwokTextView.setText(book.getTitle());

        TextView translationTextView = (TextView) convertView.findViewById(R.id.author_text_view);
        translationTextView.setText(book.getAuthors());

        return convertView;
    }
}