package com.example.android.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mjyatco on 8/14/17.
 */

public class MainActivity extends AppCompatActivity {
    static final String BOOK_LIST_VALUES = "bookListValues";

    /** List that stores the book objects */
    private BookAdapter mBookAdapter;

    /** List that stores the book objects */
    private ListView mListView;

    /** Create book list where book objects will be stored */
    ArrayList<BookObject> books = new ArrayList<>();

    /** The keyword entered for book search */
    private String mKeyword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create Adapter for book list
        if (savedInstanceState != null) {
            books = savedInstanceState.getParcelableArrayList(BOOK_LIST_VALUES);
        }

        mBookAdapter = new BookAdapter(this, books);

        // Get a reference to the ListView, and attach this adapter to it.
        mListView = (ListView) findViewById(R.id.published_books_list_view);
        View emptyView = findViewById(R.id.listview_books_null);
        mListView.setEmptyView(emptyView);
        mListView.setAdapter(mBookAdapter);

        final EditText keywordEditText = (EditText) findViewById(R.id.keyword_edit_text);

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKeyword = keywordEditText.getText().toString();
                searchBooks();
            }
        });
    }

    private void searchBooks() {
        QueryBooks bookListTask = new QueryBooks(this, this);
        bookListTask.execute(mKeyword);
    }

    public void refreshBookList(ArrayList<BookObject> result) {
        mBookAdapter.clear();
        for(BookObject book : result) {
            mBookAdapter.add(book);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArrayList(BOOK_LIST_VALUES, books);
        super.onSaveInstanceState(savedInstanceState);
    }
}
