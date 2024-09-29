package org.c07.haibazo_test.controller;

import org.c07.haibazo_test.dto.PostDto;
import org.c07.haibazo_test.model.Post;
import org.c07.haibazo_test.model.User;
import org.c07.haibazo_test.service.IPostService;
import org.c07.haibazo_test.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin
public class PostController {
    @Autowired
    IPostService postService;
    @Autowired
    IUserService userService;

    @GetMapping("/list/{userId}")
    public ResponseEntity<?> getListPostByUserID(@PathVariable Long userId){
        List<String> postList = postService.getAllByUserId(userId);
        if (postList.isEmpty()){
            return new ResponseEntity<>("List Post is empty", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList,HttpStatus.OK);
    }
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createNewPost(@PathVariable Long userId, @RequestBody PostDto postDto){
        User user = userService.findUserByUserId(userId);
        Post post = new Post();
        BeanUtils.copyProperties(postDto,post);
        post.setUser(user);
        if (postService.addNewPost(post)){
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
    }
}
