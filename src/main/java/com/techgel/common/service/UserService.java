package com.techgel.common.service;

import com.techgel.common.entity.User;

public interface UserService {
    User createUser(String username, String password);
}
