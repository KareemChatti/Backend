package com.example.projinteg.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projinteg.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    List<Worker> findByService(String serviceName);
}