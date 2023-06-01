package com.example.demo.service;


import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.SejlbådRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SejlbådService {


    @Autowired
    SejlbådRepository sejlbådRepository;


    public List<Sejlbåd> findAlleSejlbåde(){
        return sejlbådRepository.findAll();
    }


    public Sejlbåd findSejlbådMedId(int id){
        return sejlbådRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kan ikke finde en sejlbåd med det her id: " + id));
    }


    public ResponseEntity<Sejlbåd> tilføjSejlbåd(Sejlbåd sejlbåd) {

        //Jeg finder først sejlbådens ID - hvis sejlbåden allerede findes smides der en error
        boolean findessejlbåd = sejlbådRepository.existsById(sejlbåd.getId());
        if (findessejlbåd){
            throw new ResourceNotFoundException("Der findes allerede en båd med det indtastede id: " + sejlbåd.getId());
        }
        Sejlbåd nySejlbåd = sejlbådRepository.save(sejlbåd);
        return new ResponseEntity<>(nySejlbåd, HttpStatus.OK);
    }


    public ResponseEntity<Sejlbåd> opdaterSejlbåd(Sejlbåd sejlbåd) {
        boolean findesSejlbåden = sejlbådRepository.existsById(sejlbåd.getId());

        if (!findesSejlbåden){
            throw new ResourceNotFoundException("Sejlbåden med dette id: " + sejlbåd.getId() + " findes ikke i databasen");
        }
        Sejlbåd nySejlbåd = sejlbådRepository.save(sejlbåd);
        return new ResponseEntity<>(nySejlbåd,HttpStatus.OK);
    }


    public ResponseEntity<Sejlbåd> sletSejlbåd(int id){

        boolean findesSejlbåd = sejlbådRepository.existsById(id);

        if (!findesSejlbåd){
            throw new ResourceNotFoundException("Sejlbåden dette ID: " + id + " Findes ikke");
        }
        Sejlbåd slettetSejlbåd = findSejlbådMedId(id);
        sejlbådRepository.deleteById(id);
        return new ResponseEntity<>(slettetSejlbåd, HttpStatus.OK);
    }

    public List<Long> getAllBådIds() {
        List<Long> boatIds = new ArrayList<>();
        List<Sejlbåd> sejlbåde = sejlbådRepository.findAll();
        for (Sejlbåd sejlbåd : sejlbåde) {
            boatIds.add((long) sejlbåd.getId());
        }
        return boatIds;
    }
}
