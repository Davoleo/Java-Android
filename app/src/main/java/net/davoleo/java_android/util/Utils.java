package net.davoleo.java_android.util;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 19/02/2019 / 15:43
 * Class: Utils
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Utils {

    public static boolean isAlphanumeric(String s)
    {
        boolean result = true;

        for (int i = 0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if (!((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)))
                result = false;
        }

        return result;
    }

}
