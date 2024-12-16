package com.example.projinteg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projinteg.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
   
}
