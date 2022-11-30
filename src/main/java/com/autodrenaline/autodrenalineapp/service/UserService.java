package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
