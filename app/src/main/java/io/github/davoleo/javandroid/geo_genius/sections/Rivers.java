package io.github.davoleo.javandroid.geo_genius.sections;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import net.davoleo.java_android.R;
import io.github.davoleo.javandroid.util.SharedPreferencesConfig;

public class Rivers extends Activity {

    SharedPreferencesConfig sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rivers);
        sharedPreferences = new SharedPreferencesConfig(getApplicationContext());
    }

    public void onLockOut(View view) {
        sharedPreferences.writeRiverKeyStatus(false);
        this.finish();
    }
}
