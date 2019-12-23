/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 13/12/2019 / 21:24
 * Class: ArticleFragment
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package net.davoleo.java_android.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import net.davoleo.java_android.R;

public class Article extends Fragment {

    private Button button;

    public Article() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        button = view.findViewById(R.id.buttonFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentActivityExample.manager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new DynamicFragment(), null)
                        .addToBackStack(null)   //Allows backwards navigation
                        .commit();
            }
        });

        return view;
    }
}
