package io.github.davoleo.javandroid.databasetest.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import io.github.davoleo.javandroid.databasetest.DBTestHome;
import io.github.davoleo.javandroid.databasetest.room.User;
import net.davoleo.java_android.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadRoomUsers extends Fragment {

    private TextView textView;

    public ReadRoomUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_database_contacts, container, false);

        textView = view.findViewById(R.id.contactsDisplay);
        List<User> users = DBTestHome.database.userDAO().getUsers();

        StringBuilder infoBuilder = new StringBuilder();
        for (User user : users) {
            infoBuilder.append("\n\nID: ").append(user.getId());
            infoBuilder.append("\nName: ").append(user.getName());
            infoBuilder.append("\nE-mail: ").append(user.getEmail());
        }

        textView.setText(infoBuilder.toString());

        return view;
    }

}
