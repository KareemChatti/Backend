package com.example.projinteg.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String service; 

    @OneToMany(mappedBy = "service")
    private Set<Worker> workers;

	public Service(Long id, String name, Set<Worker> workers) {
		super();
		this.id = id;
		this.service = name;
		this.workers = workers;
	}
	@ManyToOne 
    @JoinColumn(name = "service_id") 
  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return service;
	}

	public void setName(String name) {
		this.service = name;
	}

	public Set<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	} 

}
