package com.alibaba.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.demo.model.Person;
import com.alibaba.demo.service.PersonServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class WebController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/test")
    public String hello() {
        return "hello";
    }
}
