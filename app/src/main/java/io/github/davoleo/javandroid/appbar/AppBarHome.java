package io.github.davoleo.javandroid.appbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import net.davoleo.java_android.R;

public class AppBarHome extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_home);

        toolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);
    }
}
