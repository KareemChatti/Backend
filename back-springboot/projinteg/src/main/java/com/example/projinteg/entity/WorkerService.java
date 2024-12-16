package com.example.projinteg.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projinteg.Repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository; 

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public List<Worker> getWorkersByService(String service) {
        return workerRepository.findByService(service);
    }
}