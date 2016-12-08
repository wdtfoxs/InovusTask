package ru.test.inovus.controllers;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import ru.test.inovus.entity.User;
import ru.test.inovus.security.MyUserDetail;
import ru.test.inovus.services.UserService;
import ru.test.inovus.validbean.UserValid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/sign-up")
public class RegistrationController {

    private static final String ATTR_REGISTRATION_FORM = "regForm";
    private final UserService userService;
    private final HttpServletRequest request;

    @Autowired
    public RegistrationController(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signUp(){
        request.setAttribute(ATTR_REGISTRATION_FORM, new UserValid());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String regUser(@Valid @ModelAttribute(ATTR_REGISTRATION_FORM) UserValid userValid, BindingResult bindingResult, HttpServletResponse response) throws IOException {
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

        MyUserDetail myUserDetail = new MyUserDetail(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(myUserDetail, null, myUserDetail.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/welcome";
    }
}
