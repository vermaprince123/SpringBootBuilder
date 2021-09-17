package com.example.demo.controller;

import com.example.demo.model.Model;
import com.example.demo.repo.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    MyRepo myRepo;

    @PostMapping("/insertValue")
    public Model insertValue(@RequestBody Model model){
        Model build = Model.builder().age(model.getAge())
                .city(model.getCity())
                .name(model.getName()).build();
        myRepo.save(build);
        return build;

    }

    @GetMapping("/")
    public List<Model> getValue(){
       return myRepo.findAll();
    }

}
