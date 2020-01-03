package io.github.davoleo.javandroid.sqlitetest.fragments;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import io.github.davoleo.javandroid.sqlitetest.ContactDBHelper;
import net.davoleo.java_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDatabaseContact extends Fragment {

    private Button buttonSave;
    EditText textboxID;
    EditText textboxName;
    EditText textboxEmail;

    public AddDatabaseContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_database_contact, container, false);

        buttonSave = view.findViewById(R.id.buttonAddDbEntry);
        textboxID = view.findViewById(R.id.textboxID);
        textboxName = view.findViewById(R.id.textboxName);
        textboxEmail = view.findViewById(R.id.textboxEmail);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = textboxID.getText().toString();
                String name = textboxID.getText().toString();
                String email = textboxEmail.getText().toString();

                //Normally Database tasks should be put in another background thread through an AsyncTask (not on the main one where they might cause UI Freeze)
                ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                contactDBHelper.addContact(Integer.parseInt(id), name, email, database);
                contactDBHelper.close();

                textboxID.setText("");
                textboxName.setText("");
                textboxEmail.setText("");
                Toast.makeText(getActivity(), "Contact added to the database successfully!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
