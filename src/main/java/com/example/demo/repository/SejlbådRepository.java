package com.example.demo.repository;

import com.example.demo.model.Kapsejladsræs;
import com.example.demo.model.Sejlbåd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SejlbådRepository extends JpaRepository<Sejlbåd, Integer> {
    List<Sejlbåd> findByKapsejladsræs(Kapsejladsræs kapsejladsræs);
}
