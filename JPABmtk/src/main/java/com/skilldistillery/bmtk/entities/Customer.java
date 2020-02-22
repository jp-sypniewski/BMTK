package com.skilldistillery.bmtk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	
	@OneToOne
	private UserDetail uDetail;

	
	
	//Constructors
	
	
	public Customer() {
		super();
	}



	public Customer(int id, String paymentMethod, UserDetail uDetail) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.uDetail = uDetail;
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
		return uDetail;
	}



	public void setuDetail(UserDetail uDetail) {
		this.uDetail = uDetail;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((uDetail == null) ? 0 : uDetail.hashCode());
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
		if (uDetail == null) {
			if (other.uDetail != null)
				return false;
		} else if (!uDetail.equals(other.uDetail))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", paymentMethod=" + paymentMethod + ", uDetail=" + uDetail + "]";
	}

	


	
	

}
