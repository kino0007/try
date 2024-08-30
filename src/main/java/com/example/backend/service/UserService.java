package com.example.backend.service;

import com.example.backend.modal.Huser;
import com.example.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Huser createuser(Huser huser) {
        System.out.println("Creating user");
        return userRepo.save(huser);
    }

    public List<Huser> getAll(){
        System.out.println("Finding All Users");
        return userRepo.findAll();
    }

    public Huser getUserById(int id){
       return userRepo.findById(id);
    }

    public String deleteUser(int id){

        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "User deleted";
        }else return "User not found";

    }

}
