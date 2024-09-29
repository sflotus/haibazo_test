package org.c07.haibazo_test.service;

import org.c07.haibazo_test.model.User;

public interface IUserService {
    boolean addNewUser(User user);

    User findUserByUserId(Long userId);

    boolean isExitByUsername(String userName);
}
