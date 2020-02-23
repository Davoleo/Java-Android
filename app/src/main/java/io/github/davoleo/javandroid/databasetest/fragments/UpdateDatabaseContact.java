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

public class UpdateDatabaseContact extends Fragment {

    private EditText txbID, txbName, txbEmail;
    private Button buttonUpdate;

    public UpdateDatabaseContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_database_contact, container, false);

        txbID = view.findViewById(R.id.txbUpdateID);
        txbName = view.findViewById(R.id.txbUpdateName);
        txbEmail = view.findViewById(R.id.txbUpdateEmail);

        buttonUpdate = view.findViewById(R.id.buttonUpdateContact);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        return view;
    }

    private void updateContact() {
        if (txbID.getText().toString().isEmpty())
            return;

        int id = Integer.parseInt(txbID.getText().toString());
        String name = txbName.getText().toString();
        String email = txbEmail.getText().toString();

        ContactDBHelper helper = new ContactDBHelper(getContext());
        SQLiteDatabase database = helper.getWritableDatabase();

        helper.updateContact(id, name, email, database);
        helper.close();

        Toast.makeText(getActivity(), "Contact Updated Successfully!", Toast.LENGTH_LONG).show();
        txbID.setText("");
        txbName.setText("");
        txbEmail.setText("");


    }
}
