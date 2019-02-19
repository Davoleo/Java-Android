package net.davoleo.java_android;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class GeoGeniusHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_genius_home);

        Intent i = getIntent();
        String user = i.getStringExtra("user");
        Toast.makeText(getApplicationContext(), "Welcome back " + user + " :)", Toast.LENGTH_LONG).show();
    }

}
