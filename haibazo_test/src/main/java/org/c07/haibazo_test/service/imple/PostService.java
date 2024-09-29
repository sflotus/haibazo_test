package org.c07.haibazo_test.service.imple;

import org.c07.haibazo_test.model.Post;
import org.c07.haibazo_test.repository.IPostRepository;
import org.c07.haibazo_test.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Override
    public boolean addNewPost(Post post) {
       try {
           postRepository.save(post);
           return  true;
       } catch (Exception e){
           return false;
       }
    }

    @Override
    public List<String> getAllByUserId(Long userId) {
        return postRepository.getAllPostByUserId(userId);
    }
}
