package io.github.davoleo.javandroid.geo_genius;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import net.davoleo.java_android.R;
import io.github.davoleo.javandroid.util.Utils;

import java.io.*;

public class GeoGeniusLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_genius_login);

        //loginButton onClick Handler in source code instead of XML file
        /*Button b = findViewById(R.id.buttonLogin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                System.out.println("AWSDEASDSADASDASD");
            }
        });*/
    }

    private String[] importCredentials()
    {
        TextView txbUserName = findViewById(R.id.textboxUser);
        String userName = txbUserName.getText().toString();

        TextView txbPsw = findViewById(R.id.textboxPsw);
        String psw = txbPsw.getText().toString();

        if (userName.length() > 15 && !Utils.isAlphanumeric(userName))
        {
            userName = null;
            Toast.makeText(getApplicationContext(), "Invalid Username", Toast.LENGTH_LONG).show();
        }

        if (psw.length() < 8)
        {
            psw = null;
            Toast.makeText(getApplicationContext(), "Password must be at least 8 chars long", Toast.LENGTH_LONG).show();
        }

        return new String[] {userName, psw};
    }

    public void onClickLogin(View v) throws FileNotFoundException
    {
        String userName = importCredentials()[0], psw = importCredentials()[1];

        if (userName != null && psw != null) {
            if (!checkCredentials(userName, psw, false))
                Toast.makeText(getApplicationContext(), "Wrong credentials!", Toast.LENGTH_LONG).show();
            else {
                Intent intent = new Intent(this, GeoGeniusHome.class);
                intent.putExtra("user", userName);
                startActivity(intent);
            }
        }

    }

    public void onClickRegister(View v)
    {
        String userName = importCredentials()[0], psw = importCredentials()[1];

        try
        {
            if (checkCredentials(userName, psw, true))
                Toast.makeText(getApplicationContext(), "Username (" + userName + ") already in use!", Toast.LENGTH_LONG).show();
            else
            {
                String credentialsFilename = getApplicationContext().getFilesDir().getPath() + "/" + getString(R.string.credentials_filename);
                FileWriter writer = new FileWriter(credentialsFilename, true);
                writer.append(userName).append(" ").append(psw).append("\n");
                writer.close();

                Toast.makeText(getApplicationContext(), "Account successfully registered. Welcome " + userName + "!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, GeoGeniusHome.class);
                startActivity(intent);
            }
        }
        catch (IOException e)
        {
            Toast.makeText(getApplicationContext(), "Error while registration!", Toast.LENGTH_LONG).show();
        }

    }

    private boolean checkCredentials(String userName, String psw, boolean userOnly) throws FileNotFoundException
    {
        String credentialsFilename = getApplicationContext().getFilesDir().getPath() + "/" + getString(R.string.credentials_filename);
        File f = new File(credentialsFilename);
        boolean userExists = false;

        if (f.exists())
        {
            FileReader reader = new FileReader(credentialsFilename);
            BufferedReader readerBuff = new BufferedReader(reader);

            String readLine;
            String[] accountData;

            try
            {
                while ((readLine = readerBuff.readLine()) != null && !userExists)
                {
                    accountData = readLine.split(" ");
                    userExists = accountData[0].compareTo(userName) == 0;
                    if (!userOnly)
                        userExists = accountData[0].compareTo(userName) == 0 && accountData[1].compareTo(psw) == 0;
                }
                readerBuff.close();
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            try { f.createNewFile(); }

            catch (IOException e)
            {
                Toast.makeText(getApplicationContext(), "Error during file creation!", Toast.LENGTH_LONG).show();
            }
        }

        return userExists;
    }
}
