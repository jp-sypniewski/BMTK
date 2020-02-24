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

	
	
	//Constructors
	
	
	public Customer() {
		super();
	}



	public Customer(int id, String paymentMethod, UserDetail uDetail) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.userDetail = uDetail;
	}

	


	public Customer(int id, String paymentMethod, UserDetail uDetail, List<Project> projects) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.userDetail = uDetail;
		this.projects = projects;
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



	public UserDetail getuDetail() {
		return userDetail;
	}



	public void setuDetail(UserDetail uDetail) {
		this.userDetail = uDetail;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((userDetail == null) ? 0 : userDetail.hashCode());
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
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (userDetail == null) {
			if (other.userDetail != null)
				return false;
		} else if (!userDetail.equals(other.userDetail))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", paymentMethod=" + paymentMethod + ", uDetail=" + userDetail + "]";
	}

	


	
	

}
