package com.example.android.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mjyatco on 8/14/17.
 */

public class BookObject implements Parcelable {

        private String mAuthors;
        private String mTitle;

        /**
         * Create a new Book Object.
         *
         * @param authors is the author of the book object
         * @param title is the title of the book object
         */
        public BookObject(String authors, String title) {
            mAuthors = authors;
            mTitle = title;
        }

        private BookObject(Parcel in) {
            mAuthors = in.readString();
            mTitle = in.readString();
        }


        /**
         * Get the author of the book.
         */
        public String getAuthors() {
            return mAuthors;
        }

        /**
         * Get the title of the book.
         */
        public String getTitle() {
            return mTitle;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mAuthors);
            dest.writeString(mTitle);
        }

        public static final Parcelable.Creator<BookObject> CREATOR = new Parcelable.Creator<BookObject>() {
            public BookObject createFromParcel(Parcel in) {
                return new BookObject(in);
            }

            public BookObject[] newArray(int size) {
                return new BookObject[size];
            }
        };
    }

