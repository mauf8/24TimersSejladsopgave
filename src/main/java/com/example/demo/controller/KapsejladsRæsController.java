package com.example.demo.controller;


import com.example.demo.model.Kapsejladsræs;
import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.SejlbådRepository;
import com.example.demo.service.KapsejladsRæsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KapsejladsRæsController {

    @Autowired
    KapsejladsRæsService kapsejladsRæsService;


    @GetMapping("/kapsejladsræs")
    public List<Kapsejladsræs> findAlleKapsejladsRæs() {
        return kapsejladsRæsService.findAlleKapsejladsRæs();
    }

}
