package com.okellosoftwarez.roomintro;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> userList();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);
}
