package com.example.demo.controller;


import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.SejlbådRepository;
import com.example.demo.service.SejlbådService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SejlbådController {


    @Autowired
    SejlbådService sejlbådService;




    @GetMapping("/sejlbåde")
    public List<Sejlbåd> findAlleSejlbåde() {
        return sejlbådService.findAlleSejlbåde();
    }

    @GetMapping("/sejlbåd/{id}")
    public Sejlbåd findSejlbådMedId(@PathVariable int id) {
        return sejlbådService.findSejlbådMedId(id);
    }


    @PostMapping("/sejlbåd")
    public ResponseEntity<Sejlbåd> tilføjSejlbåd(@RequestBody Sejlbåd sejlbåd) {
        try {
            return sejlbådService.tilføjSejlbåd(sejlbåd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Hvis den fejler returnere vi en fejl 500 status kode
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/sejlbåd")
    public ResponseEntity<Sejlbåd> opdaterSejlbåd(@RequestBody Sejlbåd sejlbåd) {
        try {
            return sejlbådService.opdaterSejlbåd(sejlbåd);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            //Hvis den fejler returnere vi en fejl 500 status kode
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/sejlbåd/{id}")
    public ResponseEntity<Sejlbåd> sletSejlbåd(@PathVariable int id){
        return sejlbådService.sletSejlbåd(id);
    }


    @GetMapping("/id")
    public List<Long> getBådIds() {
        return sejlbådService.getAllBådIds();
    }


    //For at bruge Request param skal man indtaste urlen sådan her http://localhost:8080/1/tilføjpoint?point=20 "?point=20" fx
    @PostMapping("/{id}/tilføjpoint")
    public Sejlbåd tilføjPoint(@PathVariable("id") int sejlbådId, @RequestParam("point") int point) {
        return sejlbådService.addPointsToSejlbåd(sejlbådId, point);
    }

    @GetMapping("/sejlbådenavne")
    public List<String> findAlleSejlbådeNavne(){
        List<Sejlbåd> listeMedSejlbåde = sejlbådService.findAlleSejlbåde();
        List<String> sejlbådeNavne = new ArrayList<>();
        for (Sejlbåd sejlbåd : listeMedSejlbåde){
            sejlbådeNavne.add(sejlbåd.getBådNavn());
        }
        return sejlbådeNavne;
    }

}
