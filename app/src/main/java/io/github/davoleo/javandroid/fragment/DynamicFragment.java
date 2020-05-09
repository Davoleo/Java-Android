package io.github.davoleo.javandroid.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.davoleo.java_android.R;

public class DynamicFragment extends Fragment {

    private TextView messageView;

    public DynamicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);

        if (getArguments() != null) {

            messageView = view.findViewById(R.id.fragmentDisplay);
            Bundle bundle = getArguments();
            String message = bundle.getString("message");
            messageView.setText(message);
        }

        return view;
    }
}
