package com.bgx.dao;

import com.bgx.entity.User;

public interface UserDao {
  /**
   *
   * @param u
   */
  void insert(User u);

  /**
   *
   * @param name
   * @return
   */
  User select(String name);
}
