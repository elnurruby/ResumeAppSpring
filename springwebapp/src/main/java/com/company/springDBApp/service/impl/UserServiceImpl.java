package com.company.springDBApp.service.impl;

import com.company.springDBApp.dao.inter.UserRepository;
import com.company.springDBApp.entities.*;
import com.company.springDBApp.service.inter.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    private UserRepository userDao;

    @Override
    public List<UserEntity> getAll(String nm, String surname, Integer nationalityID) {
        return userDao.getAll(nm, surname, nationalityID);
    }

    @Override
    public UserEntity getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserEntityByEmailAndPassword(email, password);
    }

    @Override
    public UserEntity getByID(int id) {
        return userDao.getById(id);
    }

    @Override
    public void addUser(UserEntity u) {
        userDao.save(u);
    }

    @Override
    public void updateUser(UserEntity u) {
        userDao.save(u);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteById(id);
    }

    public void updateUserName(UserEntity u, String name) {
        UserEntity user = userDao.getById(u.getId());
        user.setName(name);
        userDao.save(user);
    }
}
