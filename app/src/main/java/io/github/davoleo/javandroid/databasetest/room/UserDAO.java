/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 23/02/2020 / 20:57
 * Class: UserDAO
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.databasetest.room;

import androidx.room.*;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Delete
    void removeUser(User user);

    @Update
    void updateUser(User user);

}
