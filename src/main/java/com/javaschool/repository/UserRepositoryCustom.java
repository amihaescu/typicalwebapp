package com.javaschool.repository;

import com.javaschool.model.User;


public interface UserRepositoryCustom {
    User findUserByUsername(String username);
}
