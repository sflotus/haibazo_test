package org.c07.haibazo_test.service;

import org.c07.haibazo_test.model.Post;

import java.util.List;

public interface IPostService {
    boolean addNewPost(Post post);

    List<String> getAllByUserId(Long userId);
}
