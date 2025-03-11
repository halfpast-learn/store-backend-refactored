package com.hplearn.user_management_service.service;

import com.hplearn.user_management_service.entity.User;

public interface UserService {

    User create(User user);

    User findOne(Long userId);

    User findByLogin(String username, String password);

    User findOrders(Long userId);

    User update(User user);

    User updatePassword(User user);
}
