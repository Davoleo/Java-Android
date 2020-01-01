/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 01/01/2020 / 19:53
 * Class: ContactDBHelper
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "contact_db";
    public static final int DB_VERSION = 1;

    //SQL Query to create a new Table
    public static final String CREATE_TABLE = "CREATE TABLE " + ContactContract.ContactEntry.TABLE_NAME +
            "(" + ContactContract.ContactEntry.CONTACT_ID + " NUMBER," + ContactContract.ContactEntry.NAME + " TEXT, " + ContactContract.ContactEntry.EMAIL + " TEXT);";
    //SQL Query to dropa table if exists
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database Operations: ", "DB Created!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table Created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
