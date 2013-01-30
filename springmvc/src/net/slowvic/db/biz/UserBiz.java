package net.slowvic.db.biz;

import java.util.List;

import net.slowvic.db.dao.UserDao;
import net.slowvic.db.page.PageInfo;
import net.slowvic.domain.User;

import org.noo.pagination.page.Page;
import org.noo.pagination.page.Pagination;
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
        throw new RuntimeException("测试回滚");
    }

    public User getUser(String userName, User user) {
        return dao.getUser(userName, user);
    }

    public List<User> getAllUsers() {
        Page page = new Pagination();
        page.setPageSize(1);
        List<User> users = dao.findAllUsers(page);
        return users;
    }

    public List<User> getAllUsers(PageInfo<User> pageInfo) {
        List<User> users = dao.findAllUsersByAnnotation(pageInfo);
        return users;
    }

    public List<User> getAllUsers(PageInfo<User> pageInfo, String userName) {
        List<User> users = dao.findAllUsersByAnnotationAndParam(pageInfo,
            userName);
        return users;
    }
}
