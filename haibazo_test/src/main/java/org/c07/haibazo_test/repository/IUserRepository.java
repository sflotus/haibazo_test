package org.c07.haibazo_test.repository;

import org.c07.haibazo_test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    boolean existsByUserName(String userName);
}
