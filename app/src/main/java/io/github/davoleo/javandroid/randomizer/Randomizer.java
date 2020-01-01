package io.github.davoleo.javandroid.randomizer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import net.davoleo.java_android.R;
import io.github.davoleo.javandroid.util.Utils;

import java.util.Random;

public class Randomizer extends AppCompatActivity  implements View.OnClickListener, View.OnLongClickListener {

    private int generatedNum = 0;
    private String generatedColor = "#000000";

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

            generatedColor = "#" + Utils.pad(r, '0', 2) + Utils.pad(g, '0', 2) + Utils.pad(b, '0', 2);

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
            this.generatedNum = generatedNumber;

            TextView label = findViewById(R.id.genNumLbl);
            label.setText(Integer.toString(generatedNumber));
    }

    public void copy(View view)
    {
        final ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if (view.getId() == R.id.buttonCopyNumber)
        {
            ClipData clipData = ClipData.newPlainText("randomNum", Integer.toString(generatedNum));
            clipboardManager.setPrimaryClip(clipData);

        }

        if (view.getId() == R.id.buttonCopyColor)
        {
            ClipData clipData = ClipData.newPlainText("randomColor", generatedColor);
            clipboardManager.setPrimaryClip(clipData);
        }
    }

    private int getRandomColor()
    {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }


}
