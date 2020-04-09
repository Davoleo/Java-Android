package io.github.davoleo.javandroid.databasetest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import androidx.room.Room;
import io.github.davoleo.javandroid.databasetest.fragments.*;
import io.github.davoleo.javandroid.databasetest.room.UserRoomDatabase;
import net.davoleo.java_android.R;

public class DBTestHome extends AppCompatActivity implements DatabaseHome.OnDatabaseOperationListener {

    public static FragmentManager fragmentManager;

    public static UserRoomDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_home);

        database = Room.databaseBuilder(getApplicationContext(), UserRoomDatabase.class, "userDB").allowMainThreadQueries().build();

        if (findViewById(R.id.dbFragmentContainer) == null || savedInstanceState != null)
            return;

        DatabaseHome homeFragment = new DatabaseHome();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.dbFragmentContainer, homeFragment).commit();
    }

    @Override
    public void onDbOperationPerform(int method) {

        switch (method)
        {
            case 0:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dbFragmentContainer, new AddDatabaseContact())
                        .addToBackStack(null)
                        .commit();
                break;
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dbFragmentContainer, new ReadDatabaseContacts())
                        .addToBackStack(null)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dbFragmentContainer, new UpdateDatabaseContact())
                        .addToBackStack(null)
                        .commit();
                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dbFragmentContainer, new DeleteDatabaseContact())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

}
