package net.davoleo.java_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import net.davoleo.java_android.sections.Capitals;

public class GeoGeniusHome extends AppCompatActivity {

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
