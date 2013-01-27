package net.slowvic.middleware.cache;

import net.slowvic.domain.User;

import org.springframework.cache.annotation.Cacheable;

public class CacheExample {
    @Cacheable(value = "user", key = "#userName")
    public User createUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        System.out.println(userName);
        return user;
    }
}
