package ru.test.inovus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AccessDeniedController {

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public RedirectView mainRedirect(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/welcome");
        return redirectView;
    }
}
