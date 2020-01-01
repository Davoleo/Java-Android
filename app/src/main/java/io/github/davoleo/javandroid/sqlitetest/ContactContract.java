/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 01/01/2020 / 19:50
 * Class: ContactContract
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.sqlitetest;

public class ContactContract {

    //To Avoid accidental initialization
    private ContactContract() { }

    public static class ContactEntry {

        public static final String TABLE_NAME = "contact_info";

        public static final String CONTACT_ID = "contact_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
    }
}
