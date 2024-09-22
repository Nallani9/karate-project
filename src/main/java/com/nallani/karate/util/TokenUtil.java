package com.nallani.karate.util;

import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class TokenUtil {

  private static final SecureRandom secureRandom = new SecureRandom(); // threadsafe
  private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // threadsafe

  public String generateToken() {
    byte[] randomBytes = new byte[24];
    secureRandom.nextBytes(randomBytes);
    return base64Encoder.encodeToString(randomBytes);
  }
}
