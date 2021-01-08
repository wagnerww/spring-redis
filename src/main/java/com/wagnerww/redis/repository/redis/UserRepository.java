package com.wagnerww.redis.repository.redis;

import java.util.Map;

import com.wagnerww.redis.models.UserModel;

public interface UserRepository {
  void save(UserModel userModel);
  Map<String, UserModel> findAll();
  UserModel findById(String id);
  void update(UserModel userModel);
  void deleteById(String id);
}
