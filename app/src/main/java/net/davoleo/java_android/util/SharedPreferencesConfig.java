/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 31/12/2019 / 15:23
 * Class: SharedPreferenceConfig
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package net.davoleo.java_android.util;

import android.content.Context;
import android.content.SharedPreferences;
import net.davoleo.java_android.R;

public class SharedPreferencesConfig {

    private SharedPreferences sharedPreferences;
    private String riverKey;

    //!! It is good practice to use the package name to make the strings unique !!
    public SharedPreferencesConfig(Context context) {

        //Initialize the shared preferences using a unique string and a context mode (PRIVATE - READABLE - WRITABLE)
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.key_preference), Context.MODE_PRIVATE);
        riverKey = context.getResources().getString(R.string.key_status_preference);
    }

    public void writeRiverKeyStatus( boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Use unique strings
        editor.putBoolean(riverKey, status);
        editor.commit();
    }

    public boolean readRiverKeyStatus() {
        boolean status;
        status = sharedPreferences.getBoolean(riverKey, false);
        return status;
    }
}
