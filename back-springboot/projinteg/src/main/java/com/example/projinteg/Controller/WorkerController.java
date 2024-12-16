package com.example.projinteg.Controller;

import com.example.projinteg.entity.Worker;
import com.example.projinteg.entity.WorkerService; // Assuming this is your service class
import com.example.projinteg.Repository.WorkerRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerService workerService; 

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        Worker savedWorker = workerRepository.save(worker);
        return new ResponseEntity<>(savedWorker, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @GetMapping("/by-service")
    public List<Worker> getWorkersByService(@RequestParam String service) {
        return workerService.getWorkersByService(service);
    }

  
   

   
    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (optionalWorker.isPresent()) {
            Worker worker = optionalWorker.get();
            worker.setFirstname(workerDetails.getFirstname());
            worker.setLastname(workerDetails.getLastname());
            worker.setDob(workerDetails.getDob());
            worker.setOccupation(workerDetails.getOccupation());
            worker.setEmail(workerDetails.getEmail());
            worker.setAddress(workerDetails.getAddress());
            worker.setPhone(workerDetails.getPhone());
            worker.setPost(workerDetails.getPost());
            worker.setCity(workerDetails.getCity());
            worker.setService(workerDetails.getService());
            worker.setExpyear(workerDetails.getExpyear());
            worker.setServiceDescription(workerDetails.getServiceDescription());
            worker.setImage(workerDetails.getImage());
            Worker updatedWorker = workerRepository.save(worker);
            return ResponseEntity.ok(updatedWorker);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a worker
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
