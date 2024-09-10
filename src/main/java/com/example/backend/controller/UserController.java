package com.example.backend.controller;

import com.example.backend.modal.Huser;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Huser createUser(@RequestBody Huser huser) {
        return userService.createuser(huser);
    }

    @GetMapping("/getall")
    public List<Huser> getAll(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public Huser getById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getm")
    public String getM(){
        return "Hello";
    }

    @GetMapping("/getxyz")
    public String getX(){
        return "XYZ";
    }

    @GetMapping("/getabc")
    public String getA(){
        return "ABC";
    }

}
