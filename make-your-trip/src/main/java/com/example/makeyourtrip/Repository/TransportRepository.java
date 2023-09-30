package com.example.makeyourtrip.Repository;

import com.example.makeyourtrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
