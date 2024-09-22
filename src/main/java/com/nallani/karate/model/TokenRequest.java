package com.nallani.karate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenRequest {

  @NotBlank(message = "client_id is mandatory")
  @JsonProperty("client_id")
  private String clientId;

  @NotBlank(message = "client_secret is mandatory")
  @JsonProperty("client_secret")
  private String clientSecret;

  @NotBlank(message = "grant_type is mandatory")
  @JsonProperty("grant_type")
  private String grantType;

  private String scope;
}
