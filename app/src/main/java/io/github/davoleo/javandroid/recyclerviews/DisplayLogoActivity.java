package io.github.davoleo.javandroid.recyclerviews;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import net.davoleo.java_android.R;

public class DisplayLogoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_logo);

        imageView = findViewById(R.id.logoDisplay);
        imageView.setImageResource(getIntent().getIntExtra("imageId", 0));
    }
}
