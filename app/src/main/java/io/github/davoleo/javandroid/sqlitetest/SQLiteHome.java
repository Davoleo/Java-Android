package io.github.davoleo.javandroid.sqlitetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.github.davoleo.javandroid.sqlitetest.fragments.*;
import net.davoleo.java_android.R;

public class SQLiteHome extends AppCompatActivity implements DatabaseHome.OnDatabaseOperationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_home);

        if (findViewById(R.id.dbFragmentContainer) == null || savedInstanceState != null)
            return;

        DatabaseHome homeFragment = new DatabaseHome();
        getSupportFragmentManager().beginTransaction().add(R.id.dbFragmentContainer, homeFragment).commit();
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
