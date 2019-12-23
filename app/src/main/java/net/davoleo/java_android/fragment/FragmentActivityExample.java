/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 13/12/2019 / 21:XX
 * Class: FragmentActivityExample
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package net.davoleo.java_android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import net.davoleo.java_android.R;

public class FragmentActivityExample extends AppCompatActivity {

    public static FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        manager = getSupportFragmentManager();

        if (findViewById(R.id.fragmentContainer) != null) {
            //Return when the activity is resumed from a paused state
            if (savedInstanceState != null)
                return;
        }
    }
}
