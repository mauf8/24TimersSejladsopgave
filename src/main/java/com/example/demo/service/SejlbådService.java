package com.example.demo.service;


import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Kapsejladsræs;
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

    public List<Sejlbåd> findAlleSejlbåde() {
        return sejlbådRepository.findAll();
    }

    public Sejlbåd findSejlbådMedId(int id) {
        return sejlbådRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kan ikke finde en sejlbåd med dette id: " + id));
    }

    public ResponseEntity<Sejlbåd> tilføjSejlbåd(Sejlbåd sejlbåd) {
        boolean findesSejlbåden = sejlbådRepository.existsById(sejlbåd.getId());

        if (findesSejlbåden) {
            throw new ResourceNotFoundException("Der findes allerede en båd med dette id: " + sejlbåd.getId());
        }

        Sejlbåd nySejlbåd = sejlbådRepository.save(sejlbåd);
        return new ResponseEntity<>(nySejlbåd, HttpStatus.OK);
    }

    public ResponseEntity<Sejlbåd> opdaterSejlbåd(Sejlbåd sejlbåd) {
        boolean findesSejlbåden = sejlbådRepository.existsById(sejlbåd.getId());

        if (!findesSejlbåden) {
            throw new ResourceNotFoundException("Sejlbåden med dette id: " + sejlbåd.getId() + " findes ikke i databasen.");
        }

        Sejlbåd opdateretSejlbåd = sejlbådRepository.save(sejlbåd);
        return new ResponseEntity<>(opdateretSejlbåd, HttpStatus.OK);
    }

    public ResponseEntity<Sejlbåd> sletSejlbåd(int id) {
        Sejlbåd sejlbåd = sejlbådRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kan ikke finde en sejlbåd med dette id: " + id));

        sejlbådRepository.delete(sejlbåd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Long> getAllBådIds() {
        List<Sejlbåd> sejlbåde = sejlbådRepository.findAll();
        List<Long> bådIds = new ArrayList<>();
        for (Sejlbåd sejlbåd : sejlbåde) {
            bådIds.add((long) sejlbåd.getId());
        }
        return bådIds;
    }


    public Sejlbåd addPointsToSejlbåd(int sejlbådId, int point) {
        Sejlbåd sejlbåd = sejlbådRepository.findById(sejlbådId)
                .orElseThrow(() -> new ResourceNotFoundException("Kan ikke finde en sejlbåd med dette id: " + sejlbådId));

        int currentPoints = sejlbåd.getPoint();
        sejlbåd.setPoint(currentPoints + point);
        return sejlbådRepository.save(sejlbåd);

    }



}