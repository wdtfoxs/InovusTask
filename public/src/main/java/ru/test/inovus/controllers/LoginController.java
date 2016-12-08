package ru.test.inovus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/sign-in")
public class LoginController {

    private final HttpServletRequest request;

    @Autowired
    public LoginController(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Boolean error){
        request.setAttribute("error", error);
        return "login";
    }

}
