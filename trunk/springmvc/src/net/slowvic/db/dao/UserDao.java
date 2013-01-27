package net.slowvic.db.dao;

import net.slowvic.domain.User;

public interface UserDao {
    User getUser(int id);

    void addUser(User user);
}
