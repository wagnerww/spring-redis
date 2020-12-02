package com.wagnerww.redis.repository.redis.impl;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wagnerww.redis.models.UserModel;
import com.wagnerww.redis.repository.redis.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private static final String KEY = "USER";
  private static String keyHash = KEY.concat(":%s");

  private final Jedis jedis;

  @Autowired
  public UserRepositoryImpl(Jedis jedis) {
    this.jedis = jedis;
  }

  @Override
  public void save(UserModel userModel) {
    // Map<String, String> mapUser = (Map<String, String>)
    // this.convertValue(userModel, Map.class);
    ObjectMapper objectMapper = new ObjectMapper();
    String userJson;
    try {
      userJson = objectMapper.writeValueAsString(userModel);
      this.jedis.set(String.format(keyHash, userModel.getId()), userJson);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
   //this.jedis.hmset(String.format(keyHash, userModel.getId()), mapUser);
    //this.jedis.sadd(KEY, userModel.getId().toString());
  }

  @Override
  public Map<String, UserModel> findAll() {
    //return hashOperations.entries(KEY);
    return null;
  }

  @Override
  public UserModel findById(String id) {
   // return (UserModel) hashOperations.get(KEY, id);
   return null;
  }

  @Override
  public void update(UserModel userModel) {
    save(userModel);
  }

  @Override
  public void deleteById(String id) {
    //hashOperations.delete(KEY, id);
  }

  private Object convertValue(Object object, Class clazz) {
    return new ObjectMapper().convertValue(object, clazz);
}

}