package com.example.TokenAuthentication.controllers;

import com.example.TokenAuthentication.models.User;
import com.example.TokenAuthentication.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


  @Autowired
  UserDetailsServiceImpl userDetailsService;


  @GetMapping("/users")
  public List<User> fetchAllUser()
  {
    return userDetailsService.fetchAllUser();
  }

  @DeleteMapping("/users/{id}")
  public String deleteUserById(@PathVariable("id") Long id)
  {
    userDetailsService.deleteUserById(id);
    return "Deleted Successfully";
  }

}
