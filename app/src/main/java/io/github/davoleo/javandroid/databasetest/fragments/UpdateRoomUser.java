package io.github.davoleo.javandroid.databasetest.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import io.github.davoleo.javandroid.databasetest.DBTestHome;
import io.github.davoleo.javandroid.databasetest.room.User;
import net.davoleo.java_android.R;

public class UpdateRoomUser extends Fragment {

    private EditText textId, textName, textEmail;
    private Button buttonUpdate;

    public UpdateRoomUser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_database_contact, container, false);

        ((TextView) view.findViewById(R.id.updateContactsTextTitle)).setText("Update User");
        textId = view.findViewById(R.id.txbUpdateID);
        textName = view.findViewById(R.id.txbUpdateName);
        textEmail = view.findViewById(R.id.txbUpdateEmail);
        buttonUpdate = view.findViewById(R.id.buttonUpdateContact);

        textId.setHint("User ID");
        textName.setHint("User Name");
        textEmail.setHint("User E-mail");

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setId(Integer.parseInt(textId.getText().toString()));
                user.setName(textName.getText().toString());
                user.setEmail(textEmail.getText().toString());

                DBTestHome.database.userDAO().updateUser(user);
                Toast.makeText(getActivity(), "Updated user " + user.getName() + " successfully!", Toast.LENGTH_SHORT).show();

                textId.setText("");
                textName.setText("");
                textEmail.setText("");
            }
        });

        return view;
    }

}
