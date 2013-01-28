package net.slowvic.db.dao;

import net.slowvic.domain.User;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User getUserById(int id);

    User getUser(@Param("userName") String userName, @Param("user") User user);

    void addUser(User user);
}
