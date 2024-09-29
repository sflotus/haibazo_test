package org.c07.haibazo_test.repository;

import org.c07.haibazo_test.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post,Long> {
    @Query(nativeQuery = true,
    value = "select p.content from post p where p.create_by = ?1")
    List<String> getAllPostByUserId(Long userId);
}
