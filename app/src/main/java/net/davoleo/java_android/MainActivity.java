package net.davoleo.java_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import net.davoleo.java_android.geo_genius.GeoGeniusLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGeoGenius(View view)
    {
        Intent intent = new Intent(this, GeoGeniusLogin.class);
        startActivity(intent);
    }
}
