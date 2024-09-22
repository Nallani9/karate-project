package com.nallani.karate.controller;

import com.nallani.karate.model.*;
import com.nallani.karate.service.TokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

  @Autowired TokenService service;

  @PostMapping(
      path = "/oauth/v1",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TokenResponse> postToken(
      @RequestParam("client_id") @Valid @NotNull @NotBlank String clientId,
      @RequestParam("client_secret") @Valid @NotNull @NotBlank String clientSecret,
      @RequestParam("grant_type") @Valid @NotNull @NotBlank String grantType)
      throws Exception {
    TokenResponse response = new TokenResponse();
    response.setAccessToken(service.token());
    return ResponseEntity.ok().body(response);
  }

  @PostMapping(
      path = "/oauth/v2",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<TokenResponse> postTokenBody(
      @Valid TokenRequest tokenRequest, BindingResult result) throws Exception {
    // Handle validation errors
    if (result.hasErrors()) {
      throw new Exception(result.getAllErrors().toString());
    }
    TokenResponse response = new TokenResponse();
    response.setAccessToken(service.token());
    return ResponseEntity.ok().body(response);
  }

  @GetMapping(
      path = "/get-user",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserResponse> getUser(
      @RequestHeader("AppId") String appId,
      @RequestHeader("AppName") String appName,
      @RequestHeader("id") String id,
      @RequestHeader("REQ-ID") String reqId,
      @RequestHeader("userId") String userId)
      throws Exception {
    UserResponse response = new UserResponse();
    response.setUser(userId);
    response.setDetails(appId);
    return ResponseEntity.ok().body(response);
  }

  @PostMapping(
      path = "/get-users-list",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UsersListResponse> getUserList(
      @RequestHeader("AppId") String appId,
      @RequestHeader("AppName") String appName,
      @RequestHeader("id") String id,
      @RequestHeader("REQ-ID") String reqId,
      @RequestBody() UsersListRequest input)
      throws Exception {
    UsersListResponse response = new UsersListResponse();
    response.setUsers(input.getUsers());
    response.setDetails(appId);
    return ResponseEntity.ok().body(response);
  }
}
