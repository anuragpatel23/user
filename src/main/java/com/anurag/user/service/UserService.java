package com.anurag.user.service;

import com.anurag.user.dto.UserDTO;
import com.anurag.user.entity.User;
import com.anurag.user.mapper.UserMapper;
import com.anurag.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO){
        User addedUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(addedUser);
    }

    public ResponseEntity<UserDTO> findUserById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
