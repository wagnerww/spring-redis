package com.wagnerww.redis.controllers;

import com.wagnerww.redis.models.UserModel;
import com.wagnerww.redis.repository.redis.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public void save(@RequestBody UserModel userModel) {
    userRepository.save(userModel);
  }

}