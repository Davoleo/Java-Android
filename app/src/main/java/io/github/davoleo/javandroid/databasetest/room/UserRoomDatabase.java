/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 23/02/2020 / 20:58
 * Class: UserDatabase
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.databasetest.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

}
