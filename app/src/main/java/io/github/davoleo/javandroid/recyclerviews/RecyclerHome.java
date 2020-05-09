package io.github.davoleo.javandroid.recyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import net.davoleo.java_android.R;

import java.util.Arrays;
import java.util.List;

public class RecyclerHome extends AppCompatActivity {

    //Recycler View Handler
    private RecyclerView recyclerView;
    private List<String> list;

    //Recycler View Necessities:
    //1) The Layout Manager controls how the items are arranged
    //2) The View Holder that controls what each item shows and it is shown in the list
    //3) The Adapter places the View Holder in its proper position in the Layout
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_home);

        recyclerView = findViewById(R.id.recyclerViewSample);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list = Arrays.asList(getResources().getStringArray(R.array.android_verions));
        adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        //Improve performances when it doesn't need to be dynamic depending on the count of items
        recyclerView.setHasFixedSize(true);

    }
}
