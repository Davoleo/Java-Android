package io.github.davoleo.javandroid.recyclerviews;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import net.davoleo.java_android.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerHome extends AppCompatActivity implements SearchView.OnQueryTextListener {

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
        adapter = new RecyclerAdapter(list, this);
        recyclerView.setAdapter(adapter);

        //Improve performances when it doesn't need to be dynamic depending on the count of items
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        List<String> filteredList = new ArrayList<>();
        for (String version : list) {
            if (version.toLowerCase().contains(userInput)) {
                filteredList.add(version);
            }
        }

        adapter.updateList(filteredList);
        return true;
    }
}
