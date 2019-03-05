package net.davoleo.java_android.geo_genius;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import net.davoleo.java_android.R;

import java.util.Arrays;
import java.util.List;

public class ActivityContactList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        String[] nomi = new String[] { "Antonio", "Carla", "Dario",
                "Donatella", "Erminia", "Ernesto", "Fabrizio", "Federico",
                "Federica", "Fabrizio", "Gianna", "Gianni", "Giannino", "Laura",
                "Lella", "Lillo", "Maria", "Mariano", "Mario", "Patrizia",
                "Patrizio", "Sandra", "Sandrino" };

        List<String> dataSource = Arrays.asList(nomi);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataSource);

        ListView contacts = findViewById(R.id.contactsList);
        contacts.setAdapter(adapter);
        contacts.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String contact = (String) parent.getItemAtPosition(position);

        Toast.makeText(getApplicationContext(), "Index: " + position + " Contact: " + id, Toast.LENGTH_LONG).show();
    }
}
