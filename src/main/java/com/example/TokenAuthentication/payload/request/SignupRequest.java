package com.example.TokenAuthentication.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank(message = "Username can not blank")

  private String username;

  @NotBlank(message = "Email can not be blank")
  @Email(message = "Invalid Email")
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max =8)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
