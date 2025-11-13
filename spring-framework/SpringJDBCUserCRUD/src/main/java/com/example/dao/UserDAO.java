package com.example.dao;

import java.util.List;
import com.example.model.User;

public interface UserDAO {
    int save(User user);
    int update(User user);
    int delete(int id);
    User get(int id);
    List<User> list();
}
