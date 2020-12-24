package com.bgx.service;

import com.bgx.dao.UserDao;
import com.bgx.entity.User;
import com.bgx.util.MD5Util;
import com.bgx.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public void insert(User u) {
        String name = u.getName();
        String password = u.getPassword();
        String salt = RandomUtil.getRandomSalt(4);
        String md5 = MD5Util.getMD5(password + salt);
        Date date = new Date();
        String id = UUID.randomUUID().toString();
        User dbuser = new User(id, name, md5, salt, date);
        ud.insert(dbuser);
    }

    @Override
    public User select(User user) {

        User user1 = ud.select(user.getName());
        if (user1 != null) {
            String passworddb = user1.getPassword();
            String salt = user1.getSalt();
            String passwordin = user.getPassword();
            String md5 = MD5Util.getMD5(passwordin + salt);
            if (md5.equals(passworddb)) {
                return user;
            } else {
                throw new RuntimeException("密码错误");
            }
        } else {
            throw new RuntimeException("用户名不存在");
        }
    }
}
