package io.github.davoleo.javandroid.databasetest.fragments;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import io.github.davoleo.javandroid.databasetest.ContactDBHelper;
import net.davoleo.java_android.R;

public class DeleteDatabaseContact extends Fragment {

    EditText txbID;
    Button buttonDelete;

    public DeleteDatabaseContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_database_contact, container, false);

        txbID = view.findViewById(R.id.txbDeleteID);

        buttonDelete = view.findViewById(R.id.buttonDeleteContact);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 removeContact();
            }
        });

        return view;
    }

    private void removeContact() {
        if (txbID.getText().toString().isEmpty())
            return;

        ContactDBHelper helper = new ContactDBHelper(getContext());
        SQLiteDatabase database = helper.getWritableDatabase();

        int id = Integer.parseInt(txbID.getText().toString());

        helper.removeContact(id, database);
        helper.close();

        txbID.setText("");
        Toast.makeText(getContext(), "Contact Removed Successfully!", Toast.LENGTH_LONG).show();
    }

}
