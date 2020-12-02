package com.wagnerww.redis.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserModel implements Serializable {

  private static final long serialVersionUID = -7178515426382247993L;
  private String id;
  private String name;
  private String eamil;

}