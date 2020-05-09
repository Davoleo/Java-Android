/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 13/12/2019 / 21:XX
 * Class: FragmentActivityExample
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package io.github.davoleo.javandroid.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import net.davoleo.java_android.R;

public class FragmentActivityExample extends AppCompatActivity implements Article.OnMessageReadListener {

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

    @Override
    public void onMessageRead(String message) {
        Toast preToast = Toast.makeText(this, "MESSAGE FROM THE FRAGMENT", Toast.LENGTH_SHORT);
        preToast.setMargin(50, 50);
        preToast.show();

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        DynamicFragment dynamicFragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        dynamicFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = manager.beginTransaction().replace(R.id.fragmentContainer, dynamicFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
