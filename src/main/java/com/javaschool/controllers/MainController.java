package com.javaschool.controllers;

import com.javaschool.model.User;
import com.javaschool.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@RequestParam(name = "user") String username, @RequestParam(name = "pass") String password) {
        usersRepository.save(new User(username, password));
        logger.info(String.format("Created user: %s ", username));
        return "connected";
    }

}
