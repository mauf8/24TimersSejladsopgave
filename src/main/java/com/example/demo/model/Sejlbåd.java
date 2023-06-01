package com.example.demo.model;

import com.example.demo.bådTypeEnum.BådType;
import jakarta.persistence.*;


@Entity
public class Sejlbåd {

@jakarta.persistence.Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;



    private String bådNavn;



    //Her kalder jeg på @Enumerated(EnumType.STRING), som instruere JPA til at lægge enum værdien ned i databasen som strings.
    @Enumerated(EnumType.STRING)
    private BådType bådType;


    public String getBådNavn() {
        return bådNavn;
    }

    public void setBådNavn(String bådNavn) {
        this.bådNavn = bådNavn;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public BådType getBådType() {
        return bådType;
    }

    public void setBådType(BådType bådType) {
        this.bådType = bådType;
    }


}
