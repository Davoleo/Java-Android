package io.github.davoleo.javandroid;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import io.github.davoleo.javandroid.fragment.FragmentActivityExample;
import io.github.davoleo.javandroid.geo_genius.GeoGeniusLogin;
import io.github.davoleo.javandroid.randomizer.Randomizer;
import io.github.davoleo.javandroid.databasetest.DBTestHome;
import net.davoleo.java_android.R;

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

    public void startRandomizer(View view)
    {
        Intent intent = new Intent(this, Randomizer.class);
        startActivity(intent);
    }

    public void startFragmentTest(View view)
    {
        Intent intent = new Intent(this, FragmentActivityExample.class);
        startActivity(intent);
    }

    public void startSQLTest(View view) {
        startActivity(new Intent(this, DBTestHome.class));
    }
}
