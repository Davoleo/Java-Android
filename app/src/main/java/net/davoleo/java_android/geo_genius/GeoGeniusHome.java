package net.davoleo.java_android.geo_genius;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import net.davoleo.java_android.R;
import net.davoleo.java_android.geo_genius.sections.Capitals;
import net.davoleo.java_android.geo_genius.sections.Rivers;

public class GeoGeniusHome extends AppCompatActivity implements View.OnLongClickListener {

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_genius_home);
        setTitle("Geo Genius");

        Intent i = getIntent();
        user = i.getStringExtra("user");
        Toast.makeText(getApplicationContext(), "Welcome back " + user + " :)", Toast.LENGTH_LONG).show();

        //listener
        (findViewById(R.id.mapView)).setOnLongClickListener(this);
        (findViewById(R.id.buttonCapitals)).setOnLongClickListener(this);

    }

    public void onSectionButtonClick(View v)
    {
        int ID = v.getId();
        startSection(ID);
    }

    @Override
    public boolean onLongClick(View v)
    {
        if (v.getId() != R.id.mapView)
        {
            Toast.makeText(getApplicationContext(), "Long Press", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActivityContactList.class);
            startActivity(intent);
        }
        else
        {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext(), "AREA DENIED!", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        0);
            }
            else
            {
                Cursor contactsIterator = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                while (contactsIterator.moveToNext())
                {
                    int colPos = contactsIterator.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
                    String nextContact = contactsIterator.getString(colPos);
                    Toast.makeText(getApplicationContext(), nextContact, Toast.LENGTH_SHORT).show();
                }
                contactsIterator.close();
            }

        }
        return true;    //if false long clicks call both this and the onClick method

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.geo_genius_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int ID = item.getItemId();
        startSection(ID);
        return true;
    }

    private void startSection(int ID)
    {
        Bundle b = new Bundle();
        b.putString("user", user);

        switch (ID)
        {
            case R.id.action_capitals:
            case R.id.buttonCapitals:
                Intent intentCapitals = new Intent(this, Capitals.class);
                intentCapitals.putExtras(b);
                startActivity(intentCapitals);
                break;
            case R.id.action_rivers:
            case R.id.buttonRivers:
                Intent intentRivers = new Intent(this, Rivers.class);
                intentRivers.putExtras(b);
                startActivity(intentRivers);
                break;
            case R.id.action_lakes:
                break;
            case R.id.action_monuments:
                break;

        }
    }
}
