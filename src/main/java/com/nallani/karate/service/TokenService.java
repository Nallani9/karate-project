package com.nallani.karate.service;

import com.nallani.karate.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Autowired TokenUtil tokenUtil;

  public String token() {
    return tokenUtil.generateToken();
  }
}
