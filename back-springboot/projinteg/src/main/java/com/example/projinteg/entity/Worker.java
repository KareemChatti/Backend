package com.example.projinteg.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private Date dob;
    private String occupation;
    private String email;
    private String address;
    private String phone;
    private String post;
    private String city;
    private String service; 
    private String expyear;
    private String serviceDescription;
    private String image;
    
  

    public Worker(Long id, String firstname, String lastname, Date dob, String occupation, String email,
                  String address, String phone, String post, String city, String service,
                  String expyear, String serviceDescription , String image) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.occupation = occupation;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.post = post;
        this.city = city;
        this.service = service;
        this.expyear = expyear;
        this.serviceDescription = serviceDescription;
        this.image=image ;
    }

    public Worker() {
        super();
    }

  
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPost() { return post; }
    public void setPost(String post) { this.post = post; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public String getExpyear() { return expyear; }
    public void setExpyear(String expyear) { this.expyear = expyear; }
    public String getServiceDescription() { return serviceDescription; }
    public void setServiceDescription(String serviceDescription) { this.serviceDescription = serviceDescription;
    
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
