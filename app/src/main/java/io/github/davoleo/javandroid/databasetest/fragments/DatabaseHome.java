package io.github.davoleo.javandroid.databasetest.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import io.github.davoleo.javandroid.databasetest.DBTestHome;
import net.davoleo.java_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatabaseHome extends Fragment implements View.OnClickListener {

    private Button buttonAdd;
    private Button buttonView;
    private Button buttonUpdate;
    private Button buttonRemove;

    private Button buttonRoomAdd;
    private Button buttonRoomView;
    private Button buttonRoomUpdate;
    private Button buttonRoomRemove;

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

        buttonAdd = view.findViewById(R.id.btnAddContact);
        buttonAdd.setOnClickListener(this);

        buttonView = view.findViewById(R.id.btnViewContacts);
        buttonView.setOnClickListener(this);

        buttonUpdate = view.findViewById(R.id.btnUpdateContact);
        buttonUpdate.setOnClickListener(this);

        buttonRemove = view.findViewById(R.id.btnRemoveContact);
        buttonRemove.setOnClickListener(this);

        buttonRoomAdd = view.findViewById(R.id.btnAddUser);
        buttonRoomAdd.setOnClickListener(this);

        buttonRoomView = view.findViewById(R.id.btnViewUsers);
        buttonRoomView.setOnClickListener(this);

        buttonRoomRemove = view.findViewById(R.id.btnRemoveUser);
        buttonRoomRemove.setOnClickListener(this);

        buttonRoomUpdate = view.findViewById(R.id.btnUpdateUser);
        buttonRoomUpdate.setOnClickListener(this);

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
            case R.id.btnRemoveContact:
                databaseOperationListener.onDbOperationPerform(3);
                break;

            case R.id.btnAddUser:
                DBTestHome.fragmentManager.beginTransaction()
                        .replace(R.id.dbFragmentContainer, new AddRoomUser())
                        .addToBackStack(null).commit();
                break;
            case R.id.btnViewUsers:
                DBTestHome.fragmentManager.beginTransaction()
                        .replace(R.id.dbFragmentContainer, new ReadRoomUsers())
                        .addToBackStack(null).commit();
                break;
            case R.id.btnRemoveUser:
                DBTestHome.fragmentManager.beginTransaction()
                        .replace(R.id.dbFragmentContainer, new DeleteRoomUser())
                        .addToBackStack(null).commit();
                break;
            case R.id.btnUpdateUser:
                DBTestHome.fragmentManager.beginTransaction()
                        .replace(R.id.dbFragmentContainer, new UpdateRoomUser())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
