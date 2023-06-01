package com.example.demo.controller;

import com.example.demo.bådTypeEnum.BådType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class BådTypeController {

    // Denne controller bruges til at fylde dropdown listen inde i frontend så man kan  vælge en båd type
    @GetMapping("/bådtyper")
    public List<BådType> getAllBådTyper() {
        // denne return metode returnere en arrayliste med enum værdierne
        return Arrays.asList(BådType.values());
    }
}
