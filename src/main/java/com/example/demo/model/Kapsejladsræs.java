package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Kapsejladsræs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String navn;


    private LocalDate dato;

    @OneToMany(mappedBy = "kapsejladsræs")
    @JsonBackReference
    private List<Sejlbåd> sejlbåd;


    public List<Sejlbåd> getSejlbåde() {
        return sejlbåd;
    }


    public List<Sejlbåd> getSejlbåd() {
        return sejlbåd;
    }

    public void setSejlbåd(List<Sejlbåd> sejlbåd) {
        this.sejlbåd = sejlbåd;
    }

    public void setSejlbåde(List<Sejlbåd> sejlbåde) {
        this.sejlbåd = sejlbåde;
        for (Sejlbåd sejlbåd : sejlbåde) {
            sejlbåd.setKapsejladsræs(this);
        }
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }


}
