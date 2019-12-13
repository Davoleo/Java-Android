/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 13/12/2019 / 21:XX
 * Class: Headline
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package net.davoleo.java_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.davoleo.java_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Headline extends Fragment {

    //Required empty constructor
    public Headline() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headline, container, false);
    }
}
