/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 23/02/2020 / 20:57
 * Class: UserDAO
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.databasetest.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM users")
    List<User> getUsers();

}
