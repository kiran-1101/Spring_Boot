package com.kiran.user.service.services;

import com.kiran.user.service.entities.User;
import java.util.List;

public interface UserService {

    //user operations

    //create user

    User saveUser(User user);

    //get all user

    List<User> getAllUser();

    //get user by user-id

    User getUserByUserId(String userId);


}
