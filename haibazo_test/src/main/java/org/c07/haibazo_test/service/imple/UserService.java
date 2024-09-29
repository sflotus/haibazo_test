package org.c07.haibazo_test.service.imple;

import org.c07.haibazo_test.model.User;
import org.c07.haibazo_test.repository.IUserRepository;
import org.c07.haibazo_test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean addNewUser(User user) {
        try{
            userRepository.save(user);
            return  true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean isExitByUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
