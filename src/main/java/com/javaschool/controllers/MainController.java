package com.javaschool.controllers;

import com.javaschool.model.City;
import com.javaschool.model.User;
import com.javaschool.repository.CityRepository;
import com.javaschool.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@RequestParam(name = "user") String username, @RequestParam(name = "pass") String password) {
        usersRepository.save(new User(username, password));
        logger.info(String.format("Created user: %s ", username));
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(name = "user") String username, @RequestParam(name = "pass") String password, Model model) {
        User u = usersRepository.findUserByUsername(username);
        if (u != null){
            System.out.println("Found user!");
            model.addAttribute("cities", cityRepository.findAll());
        }
        return "connected";
    }

    @RequestMapping(value = "addCity", method = RequestMethod.POST)
    public String addCity(@RequestParam(name = "name")String name, @RequestParam(name= "state")String state, @RequestParam(name = "country")String country, Model model){
        cityRepository.save(new City(name, state, country));
        model.addAttribute("cities", cityRepository.findAll());
        return "connected";
    }

}
