package com.company.controller;

import com.company.form.*;
import com.company.springDBApp.entities.*;
import com.company.springDBApp.service.inter.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    UserServiceInter userServiceInter;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView indexGET(@ModelAttribute(value = "user") UserEntityForm user) {
        System.out.println("in indexGET");
        List<UserEntity> list = userServiceInter.getAll(user.getName(), user.getSurname(), user.getNationalityID());
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", list);
        return modelAndView;
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView indexPOST(@ModelAttribute(value = "user") UserEntityForm user) {
        try {
            userServiceInter.removeUser(user.getId());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("users");
    }



}
