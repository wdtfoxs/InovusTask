package ru.test.inovus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WelcomeController {

    private static final String CURRENT_TIME = "curTime";

    private final HttpServletRequest request;

    @Autowired
    public WelcomeController(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcomePage(){
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        String time = s.format(date).substring(0,2);
        Integer currTime = Integer.valueOf(time);
        if (currTime >= 6 && currTime < 10){
            request.setAttribute(CURRENT_TIME, "Доброе утро");
        }
        if (currTime >=10 && currTime < 18){
            request.setAttribute(CURRENT_TIME, "Добрый день");
        }
        if (currTime >=18 && currTime < 22){
            request.setAttribute(CURRENT_TIME, "Добрый вечер");
        }
        if (currTime >= 22 && currTime <6){
            request.setAttribute(CURRENT_TIME, "Доброй ночи");
        }
        return "welcome";
    }
}
