package com.example.TokenAuthentication.controllers;

import com.example.TokenAuthentication.models.User;
import com.example.TokenAuthentication.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class UserController {

  @Autowired
  UserDetailsServiceImpl userDetailsService;


  @GetMapping("/users")
  public List<User> fetchAllUser()
  {
    return userDetailsService.fetchAllUser();
  }


  @GetMapping("/users/{id}")
  public Optional<User> findById(@PathVariable("id") Long id)
  {
    return userDetailsService.findByid(id);
  }


  @DeleteMapping("/users/{id}")
  public String deleteUserById(@PathVariable("id") Long id)
  {
    userDetailsService.deleteUserById(id);
    return "Deleted Successfully";
  }

}
