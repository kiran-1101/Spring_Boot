package com.kiran.user.service.repositories;

import com.kiran.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,String> {

    //if we want to implement custom queries or method


}
