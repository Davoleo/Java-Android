package io.github.davoleo.javandroid.sqlitetest.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import io.github.davoleo.javandroid.sqlitetest.ContactContract;
import io.github.davoleo.javandroid.sqlitetest.ContactDBHelper;
import net.davoleo.java_android.R;

public class ReadDatabaseContacts extends Fragment {

    private TextView txbDisplay;

    public ReadDatabaseContacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read_database_contacts, container, false);

        txbDisplay = view.findViewById(R.id.contactsDisplay);
        readContacts();

        return view;
    }

    private void readContacts() {
        ContactDBHelper helper = new ContactDBHelper(getActivity());
        SQLiteDatabase database = helper.getReadableDatabase();

        Cursor cursor = helper.readContacts(database);
        StringBuilder info = new StringBuilder();

        while (cursor.moveToNext()) {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info.append("\n\nID: ").append(id).append("\nName: ").append(name).append("\ne-mail: ").append(email);
        }

        txbDisplay.setText(info.toString());
        helper.close();
    }

}
