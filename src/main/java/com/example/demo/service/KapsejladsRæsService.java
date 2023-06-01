package com.example.demo.service;


import com.example.demo.bådTypeEnum.BådType;
import com.example.demo.model.Kapsejladsræs;
import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.KapsejladsRæsRepository;
import com.example.demo.repository.SejlbådRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KapsejladsRæsService {


    @Autowired
    KapsejladsRæsRepository kapsejladsRæsRepository;

    @Autowired
    SejlbådRepository sejlbådRepository;




/*

    public List<Kapsejladsræs> findAlleKapsejladsRæs() {
        List<Kapsejladsræs> kapsejladsræsList = kapsejladsRæsRepository.findAll();


        for (Kapsejladsræs kapsejladsræs : kapsejladsræsList) {
            List<Sejlbåd> sejlbåde = new ArrayList<>();

            Sejlbåd sejlbåd1 = new Sejlbåd();
            sejlbåd1.setBådNavn("Sejlbåd 1");
            sejlbåd1.setPoint(0);
            sejlbåd1.setBådType(BådType.LÆNGERE_END_40FOD);
            sejlbåde.add(sejlbåd1);

            Sejlbåd sejlbåd2 = new Sejlbåd();
            sejlbåd2.setBådNavn("Sejlbåd 2");
            sejlbåd2.setPoint(0);
            sejlbåd2.setBådType(BådType.LÆNGERE_END_40FOD);
            sejlbåde.add(sejlbåd2);

            kapsejladsræs.setSejlbåde(sejlbåde);
            kapsejladsRæsRepository.save(kapsejladsræs);
        }

        return kapsejladsræsList;
    }



 */








    public List<Kapsejladsræs> findAlleKapsejladsRæs() {
        return kapsejladsRæsRepository.findAll();
    }






}
