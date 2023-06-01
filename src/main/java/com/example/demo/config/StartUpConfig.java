package com.example.demo.config;


import com.example.demo.bådTypeEnum.BådType;
import com.example.demo.model.Kapsejladsræs;
import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.KapsejladsRæsRepository;
import com.example.demo.repository.SejlbådRepository;
import com.example.demo.service.KapsejladsRæsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartUpConfig implements CommandLineRunner {


    @Autowired
    SejlbådRepository sejlbådRepository;



    @Autowired
    KapsejladsRæsRepository kapsejladsRæsRepository;





    @Override
    public void run(String... args) throws Exception {
        System.out.println("Programmet Starter nu");


        /*

        Kapsejladsræs HelsingørHavn = new Kapsejladsræs();
        HelsingørHavn.setNavn("Helsingør Havn");
        HelsingørHavn.setDato(LocalDate.of(2023, 1, 1));

        Sejlbåd de_danske_vikinger = new Sejlbåd();
        de_danske_vikinger.setBådType(BådType.LÆNGERE_END_40FOD);
        de_danske_vikinger.setBådNavn("De Danske Vikinger");
        de_danske_vikinger.setPoint(60);
        de_danske_vikinger.setKapsejladsræs(HelsingørHavn);

        Sejlbåd den_røde_sild = new Sejlbåd();
        den_røde_sild.setBådType(BådType.LÆNGERE_END_40FOD);
        den_røde_sild.setBådNavn("Den røde Sild");
        den_røde_sild.setPoint(99);
        den_røde_sild.setKapsejladsræs(HelsingørHavn);

        Sejlbåd det_gule_lyn = new Sejlbåd();
        det_gule_lyn.setBådType(BådType.LÆNGERE_END_40FOD);
        det_gule_lyn.setBådNavn("Det Gule Lyn");
        det_gule_lyn.setPoint(43);
        det_gule_lyn.setKapsejladsræs(HelsingørHavn);



        kapsejladsRæsRepository.save(HelsingørHavn);


         */

        Sejlbåd den_danske_viking = new Sejlbåd();
        den_danske_viking.setBådNavn("Den danske Viking");
        den_danske_viking.setPoint(77);
        den_danske_viking.setBådType(BådType.LÆNGERE_END_40FOD);
        sejlbådRepository.save(den_danske_viking);


        Sejlbåd den_røde_sild = new Sejlbåd();
        den_røde_sild.setBådNavn("Den røde sild");
        den_røde_sild.setPoint(10);
        den_røde_sild.setBådType(BådType.LÆNGERE_END_40FOD);
        sejlbådRepository.save(den_røde_sild);

        Sejlbåd den_gule_sild = new Sejlbåd();
        den_gule_sild.setBådNavn("Den gule sild");
        den_gule_sild.setPoint(10);
        den_gule_sild.setBådType(BådType.LÆNGERE_END_40FOD);
        sejlbådRepository.save(den_gule_sild);


        Kapsejladsræs HelsingørHavn = new Kapsejladsræs();
        HelsingørHavn.setNavn("Helsingør Havn");
        HelsingørHavn.setDato(LocalDate.of(2023, 1, 1));
        kapsejladsRæsRepository.save(HelsingørHavn);


        Kapsejladsræs KoldingHavn = new Kapsejladsræs();
        KoldingHavn.setNavn("Kolding Havn");
        KoldingHavn.setDato(LocalDate.of(2023, 3, 24));
        kapsejladsRæsRepository.save(KoldingHavn);


        Kapsejladsræs KøbenhavnOpenWater = new Kapsejladsræs();
        KøbenhavnOpenWater.setNavn("København Open Water");
        KøbenhavnOpenWater.setDato(LocalDate.of(2023, 5, 12));
        kapsejladsRæsRepository.save(KøbenhavnOpenWater);

    }







}
