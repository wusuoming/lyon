package net.slowvic.db.dao;

import java.util.List;

import net.slowvic.db.page.PageInfo;
import net.slowvic.domain.User;

import org.apache.ibatis.annotations.Param;
import org.noo.pagination.page.Page;

public interface UserDao {
    User getUserById(int id);

    User getUser(@Param("userName") String userName, @Param("user") User user);

    void addUser(User user);

    List<User> findAllUsers(Page page);

    List<User> findAllUsersByAnnotation(PageInfo<User> pageInfo);

    List<User> findAllUsersByAnnotationAndParam(PageInfo<User> pageInfo,
        @Param("userName") String userName);
}
