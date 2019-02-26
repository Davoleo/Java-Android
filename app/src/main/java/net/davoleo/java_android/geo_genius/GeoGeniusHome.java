package net.davoleo.java_android.geo_genius;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import net.davoleo.java_android.R;
import net.davoleo.java_android.geo_genius.sections.Capitals;

public class GeoGeniusHome extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

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
        (findViewById(R.id.mapView)).setOnClickListener(this);
        (findViewById(R.id.imageButton)).setOnLongClickListener(this);
        (findViewById(R.id.imageButton)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.mapView:
                Toast.makeText(getApplicationContext(), "Short Press on the map", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton:
                Toast.makeText(getApplicationContext(), "Short Press on the image button", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onLongClick(View v)
    {
        Toast.makeText(getApplicationContext(), "Long Press", Toast.LENGTH_LONG).show();
        return true;    //if false long clicks call both this and the onClick method
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.geo_genius_home, menu);
        return true;
    }

    //TODO Single method to create sub-activity for sections
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_capitals:
                Intent intent = new Intent(this, Capitals.class);
                Bundle b = new Bundle();
                b.putString("user", user);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.action_rivers:
                break;
            case R.id.action_lakes:
                break;
            case R.id.action_monuments:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
