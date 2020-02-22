package io.github.davoleo.javandroid.sqlitetest.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import net.davoleo.java_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatabaseHome extends Fragment implements View.OnClickListener {

    private Button buttonSave;
    private Button buttonView;
    private Button buttonUpdate;
    private Button buttonRemove;

    private OnDatabaseOperationListener databaseOperationListener;

    public DatabaseHome() {
        // Required empty public constructor
    }

    public interface OnDatabaseOperationListener
    {
        void onDbOperationPerform(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_database_home, container, false);

        buttonSave = view.findViewById(R.id.btnAddContact);
        buttonSave.setOnClickListener(this);

        buttonView = view.findViewById(R.id.btnViewContacts);
        buttonView.setOnClickListener(this);

        buttonUpdate = view.findViewById(R.id.btnUpdateContact);
        buttonUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = ((Activity) context);

        try {
            databaseOperationListener = ((OnDatabaseOperationListener) activity);
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement OnDatabaseOperationListener's method!");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAddContact:
                databaseOperationListener.onDbOperationPerform(0);
                break;
            case R.id.btnViewContacts:
                databaseOperationListener.onDbOperationPerform(1);
                break;
            case R.id.btnUpdateContact:
                databaseOperationListener.onDbOperationPerform(2);
                break;
        }
    }
}
