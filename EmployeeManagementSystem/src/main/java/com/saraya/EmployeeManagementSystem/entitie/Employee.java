package com.saraya.EmployeeManagementSystem.entitie;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="full_Name")
	private String fullname;
	@Column(unique=true)
    private String email;
	@Column(unique=true)
    private String identityCard; 
    private String address;
    private Double salary;
 

    
   


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(
			String fullname,
			String email, 
			String identityCard, 
			String address, 
			Double salary) {
		super();
		this.fullname=fullname;
		this.email = email;
		this.identityCard = identityCard;
		this.address = address;	
		this.salary=salary;
	}

	 
		 	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getAddress() {
		return address;
	}
	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	 
    
    
}
