package org.c07.haibazo_test.controller;

import jakarta.validation.Valid;
import org.c07.haibazo_test.dto.UserDto;
import org.c07.haibazo_test.model.Role;
import org.c07.haibazo_test.model.User;
import org.c07.haibazo_test.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        if (userService.isExitByUsername(userDto.getUserName())){
            FieldError error = new FieldError("userDto","username","Username already exists");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                map.put(error.getField(), error.getDefaultMessage());
            });
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        Role role = new Role(1L,"user"); // mặc định tạo tk role user
        user.setRole(role);
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userService.addNewUser(user)){
            return new ResponseEntity<>("Register Success",HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
}
