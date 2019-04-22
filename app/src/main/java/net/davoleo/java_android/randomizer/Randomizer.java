package net.davoleo.java_android.randomizer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import net.davoleo.java_android.R;
import net.davoleo.java_android.util.Utils;

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

            String r = Integer.toHexString(Color.red(color));
            String g = Integer.toHexString(Color.green(color));
            String b = Integer.toHexString(Color.blue(color));

            ((TextView)findViewById(R.id.color_code)).setText("#" + Utils.pad(r, '0', 2) + Utils.pad(g, '0', 2) + Utils.pad(b, '0', 2));
        }
    }

    @Override
    public boolean onLongClick(View v)
    {
        return false;
    }

    public void generateRandomNumber(View view)
    {
            System.out.println("Ho riconosciuto il bottone");
            Random rand = new Random();
            int upperBound;

            try {
                upperBound = Integer.parseInt(((TextView) findViewById(R.id.upperBoundTxb)).getText().toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid Number");
                return;
            }

            int generatedNumber = (rand.nextInt(upperBound) + 1);

            TextView label = findViewById(R.id.genNumberLbl);
            label.setText(generatedNumber);
    }

    private int getRandomColor()
    {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }


}
