package com.bgx.service;

import com.bgx.entity.User;

public interface UserService {

    /**
     *
     * @param u
     */
    void insert(User u);

    /**
     *
     * @param user
     * @return
     */
    User select(User user);

}
