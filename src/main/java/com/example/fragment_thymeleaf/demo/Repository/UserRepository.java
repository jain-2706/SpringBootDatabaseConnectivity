package com.example.fragment_thymeleaf.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.fragment_thymeleaf.demo.Entity.UserClass;


@Component
public interface UserRepository extends CrudRepository<UserClass, String> {

}
