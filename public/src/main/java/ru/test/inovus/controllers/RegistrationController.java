package ru.test.inovus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.inovus.entity.User;
import ru.test.inovus.services.UserService;
import ru.test.inovus.validbean.UserValid;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/sign-up")
public class RegistrationController {
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    private static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String signUp(){
        request.setAttribute(ATTR_REGISTRATION_FORM, new UserValid());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String regUser(@Valid @ModelAttribute(ATTR_REGISTRATION_FORM) UserValid userValid, BindingResult bindingResult){
        boolean us = userService.existsUserByUsername(userValid.getUsername());
        boolean pass = Objects.equals(userValid.getPassword(), userValid.getRepassword());
        if (bindingResult.hasErrors() || !us || !pass){
            if (!us){
                bindingResult.rejectValue("username", "error.username", "Данное имя уже занято");
            }
            if (!pass){
                bindingResult.rejectValue("password", "error.password", "Пароли не совпадают");
            }
            return "registration";
        }

        User user = new User();
        user.setUsername(userValid.getUsername());
        user.setPassword(userValid.getPassword());
        userService.addUser(user);
        return "welcome";
    }
}
