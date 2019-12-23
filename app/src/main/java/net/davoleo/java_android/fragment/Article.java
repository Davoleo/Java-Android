/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 13/12/2019 / 21:24
 * Class: ArticleFragment
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 * ----------------------------------- */

package net.davoleo.java_android.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import net.davoleo.java_android.R;

public class Article extends Fragment {

    private Button button;

    private EditText editText;
    private Button messageButton;
    OnMessageReadListener messageReadListener;

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

        editText = view.findViewById(R.id.textMessage);

        messageButton = view.findViewById(R.id.buttonFragmentMessage);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                messageReadListener.onMessageRead(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = ((Activity) context);

        try {
            messageReadListener = ((OnMessageReadListener) activity);
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()  + " Must Implement onMessageRead!");
        }

    }

    public interface OnMessageReadListener {

        void onMessageRead(String message);

    }
}
