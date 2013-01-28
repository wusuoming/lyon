package net.slowvic.db.dao.impl;

import javax.annotation.PostConstruct;

import net.slowvic.db.dao.UserDao;
import net.slowvic.domain.User;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private UserDao dao;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @PostConstruct
    public void init() {
        dao = sessionTemplate.getMapper(UserDao.class);
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return dao.getUserById(id);
    }
}
