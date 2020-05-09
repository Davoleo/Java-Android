package io.github.davoleo.javandroid.databasetest.fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteRoomUser extends Fragment {

    private EditText textBoxID;
    private Button buttonDelete;

    public DeleteRoomUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_database_contact, container, false);

        ((TextView) view.findViewById(R.id.deleteContactTextTitle)).setText("Remove User");
        textBoxID = view.findViewById(R.id.txbDeleteID);
        buttonDelete = view.findViewById(R.id.buttonDeleteContact);
        textBoxID.setHint("User ID");
        buttonDelete.setText("Delete User");

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(textBoxID.getText().toString());
                User user = new User();
                user.setId(id);

                DBTestHome.database.userDAO().removeUser(user);
                Toast.makeText(getActivity(), "User that has the id of " + id + " has been removed!", Toast.LENGTH_SHORT).show();
                textBoxID.setText("");
            }
        });

        return view;
    }

}
