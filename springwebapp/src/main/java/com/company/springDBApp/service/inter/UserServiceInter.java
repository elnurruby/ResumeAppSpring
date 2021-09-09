package com.company.springDBApp.service.inter;

import com.company.springDBApp.entities.*;
import org.springframework.stereotype.*;


import java.util.*;
@Service
public interface UserServiceInter {
    List<UserEntity> getAll(String name, String surname, Integer nationalityID);
    UserEntity getUserByEmailAndPassword(String email,String password);
    UserEntity getByID(int id);
    void addUser(UserEntity u);
    void updateUser(UserEntity u);
    void removeUser(int id);
}
