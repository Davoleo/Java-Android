package io.github.davoleo.javandroid.databasetest.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import io.github.davoleo.javandroid.databasetest.DBTestHome;
import io.github.davoleo.javandroid.databasetest.room.User;
import net.davoleo.java_android.R;

public class AddRoomUser extends Fragment {

    private EditText userID, userName, userEmail;
    private Button buttonSave;

    public AddRoomUser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_database_contact, container, false);

        //Initialize control variables
        userID = view.findViewById(R.id.textboxID);
        userName = view.findViewById(R.id.textboxName);
        userEmail = view.findViewById(R.id.textboxEmail);
        buttonSave = view.findViewById(R.id.buttonAddDbEntry);

        ((TextView) view.findViewById(R.id.addContactTitle)).setText("Add New User");
        userID.setHint("User ID");

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userID.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                DBTestHome.database.userDAO().addUser(user);
                Toast.makeText(getActivity(), "A new user was added successfully", Toast.LENGTH_SHORT).show();
                userID.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });

        return view;
    }

}
