package com.company.controller;

import com.company.form.UserEntityForm;
import com.company.springDBApp.entities.UserEntity;
import com.company.springDBApp.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceInter userServiceInter;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView indexGET(@ModelAttribute(value = "userGET") UserEntityForm user, Model model) {
        model.addAttribute("userGET", new UserEntityForm());
        model.addAttribute("userPOST", new UserEntityForm());
        List<UserEntity> list = userServiceInter.getAll(user.getName(), user.getSurname(), user.getNationalityID());
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", list);
        return modelAndView;
    }

    @ModelAttribute
    UserEntityForm getUserEntityForm() {
        return new UserEntityForm();
    }

    @PostMapping(value = "/users")
    public ModelAndView userAction(@ModelAttribute(value = "userPOST") UserEntityForm user,
                                   @RequestParam String action) {
        if (action.equals("delete")) {
            userServiceInter.removeUser(user.getId());
            ModelAndView m = new ModelAndView("users");
            m.addObject("users", userServiceInter.getAll(null, null, null));
            return m;
        }
        if (action.equals("update")) {
            UserEntity u = userServiceInter.getByID(user.getId());
            ModelAndView modelAndView = new ModelAndView("userdetail");
            modelAndView.addObject("user", u);
            return modelAndView;

        }
        return new ModelAndView("users");
    }

    @GetMapping(path = "/getAllUsers")
    @ResponseBody
    public List<UserEntity> getAllUsers() {
        return userServiceInter.getAll(null, null, null);
    }

    @PostMapping("/userDetail")
    public ModelAndView editUserDetail(HttpServletRequest request, Model model) {
        UserEntity u = userServiceInter.getByID(Integer.parseInt(request.getParameter("id")));
        u.setName(request.getParameter("name"));
        u.setSurname(request.getParameter("surname"));
        userServiceInter.updateUser(u);
        ModelAndView m = new ModelAndView("users");
        m.addObject("users", userServiceInter.getAll(null, null, null));
        model.addAttribute("userGET", new UserEntityForm());
        model.addAttribute("userPOST", new UserEntityForm());
        return m;
    }


}
