package net.davoleo.java_android.randomizer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import net.davoleo.java_android.R;

import java.util.Random;

public class Randomizer extends AppCompatActivity  implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomizer);

        findViewById(R.id.colorButton).setOnClickListener(this);
        findViewById(R.id.colorButton).setOnLongClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.colorButton)
        {
            int color = getRandomColor();
            v.setBackgroundColor(color);
            ((TextView)findViewById(R.id.color_code)).setText("#" + Integer.toHexString(Color.red(color)) + Integer.toHexString(Color.green(color)) + Integer.toHexString(Color.blue(color)));
        }
    }

    @Override
    public boolean onLongClick(View v)
    {
        return false;
    }

    private int getRandomColor()
    {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }


}
