package com.example.demo.config;


import com.example.demo.bådTypeEnum.BådType;
import com.example.demo.model.Sejlbåd;
import com.example.demo.repository.SejlbådRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartUpConfig implements CommandLineRunner {


    @Autowired
    SejlbådRepository sejlbådRepository;



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Programmet Starter nu");

        Sejlbåd de_danske_vikinger = new Sejlbåd();

        de_danske_vikinger.setBådType(BådType.LÆNGERE_END_40FOD);
       de_danske_vikinger.setBådNavn("De Danske Vikinger");

        sejlbådRepository.save(de_danske_vikinger);

        Sejlbåd Den_røde_sild = new Sejlbåd();
        Den_røde_sild.setBådType(BådType.LÆNGERE_END_40FOD);
        Den_røde_sild.setBådNavn("Den røde Sild");

        sejlbådRepository.save(Den_røde_sild);

    }


}
