package com.company.springDBApp.dao.inter;

import com.company.springDBApp.entities.*;

import java.util.*;

public interface UserDaoInter {
    List<UserEntity> getAll(String name, String surname, Integer nationalityID);
    UserEntity getUserByEmailAndPassword(String email,String password);
    UserEntity getByID(int id);
    boolean addUser(UserEntity u);
    boolean updateUser(UserEntity u);
    boolean removeUser(int id);
}
