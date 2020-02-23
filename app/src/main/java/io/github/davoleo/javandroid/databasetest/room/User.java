/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 23/02/2020 / 20:54
 * Class: User
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.databasetest.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "username")
    private String name;

    @ColumnInfo(name = "e-mail")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
