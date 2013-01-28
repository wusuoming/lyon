package net.slowvic.db.biz;

import net.slowvic.db.dao.UserDao;
import net.slowvic.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserBiz {
    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return dao.getUserById(id);
    }

    public void addUser(User user) {
        dao.addUser(user);
        // throw new RuntimeException("测试回滚");
    }

    public User getUser(String userName, User user) {
        return dao.getUser(userName, user);
    }
}
