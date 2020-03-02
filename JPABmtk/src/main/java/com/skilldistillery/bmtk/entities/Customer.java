package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	
	@OneToOne
	@JoinColumn(name="user_detail_id")
	private UserDetail userDetail;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Project> projects;
	
	private Boolean active;

	
	
	//Constructors
	
	
	public Customer() {
		super();
	}



	public Customer(int id, String paymentMethod, UserDetail userDetail, List<Project> projects, Boolean active) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.userDetail = userDetail;
		this.projects = projects;
		this.active = active;
	}




	public Customer(int id, String paymentMethod, UserDetail uDetail, List<Project> projects) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.userDetail = uDetail;
		this.projects = projects;
	}

	


	public Boolean getActive() {
		return active;
	}



	public void setActive(Boolean active) {
		this.active = active;
	}



	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public UserDetail getUserDetail() {
		return userDetail;
	}



	public void setUserDetail(UserDetail uDetail) {
		this.userDetail = uDetail;
	}



	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", paymentMethod=" + paymentMethod + ", userDetail=" + userDetail + ", active="
				+ active + "]";
	}

	


	
	

}
