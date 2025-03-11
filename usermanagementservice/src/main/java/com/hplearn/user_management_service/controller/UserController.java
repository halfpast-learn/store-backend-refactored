package com.hplearn.user_management_service.controller;

import com.hplearn.user_management_service.entity.User;
import com.hplearn.user_management_service.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{userId}")
    public User findOne(@PathVariable Long userId) {
        return userService.findOne(userId);
    }

    @PostMapping("/name/login")
    public User findByLogin(@RequestBody String[] info) {
        return userService.findByLogin(info[0], info[1]);
    }

    @GetMapping("/{id}/orders")
    public User findOrders(@PathVariable("id") Long userId) {
        return userService.findOrders(userId);
    }

    @PatchMapping("/{id}/update")
    public User update(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.update(user);
    }

    @PatchMapping("/{id}/updatepw")
    public User updatePassword(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updatePassword(user);
    }
}
