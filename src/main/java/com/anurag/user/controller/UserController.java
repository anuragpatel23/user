package com.anurag.user.controller;

import com.anurag.user.dto.UserDTO;
import com.anurag.user.entity.User;
import com.anurag.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    private ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO addedUser = userService.addUser(userDTO);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUser/{id}")
    private ResponseEntity<UserDTO> fetchUser(@PathVariable Integer id){
        return userService.findUserById(id);
    }
}
