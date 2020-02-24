package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_detail")
public class UserDetail {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="first_name")
		private String firstName;
		@Column(name="last_name")
		private String lastName;
		private String email;
		private String street;
		private String city;
		private String zipcode;
		private String country;
		private String phone;
		
		@JsonIgnore
		@OneToOne(mappedBy="userDetail")
		private User user;
		
		@JsonIgnore
		@ManyToMany(mappedBy="owners")
		private List<Company> myCompanies;
		
		@JsonIgnore
		@OneToOne(mappedBy="userDetail")
		private Customer customer;
		
	//Constructors
		
		public UserDetail() {
			super();
		}



	public UserDetail(int id, String firstName, String lastName, String email, String street, String city,
			String zipcode, String country, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + ", country=" + country + ", phone="
				+ phone + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Company> getMyCompanies() {
		return myCompanies;
	}



	public void setMyCompanies(List<Company> myCompanies) {
		this.myCompanies = myCompanies;
	}
	
	



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		UserDetail other = (UserDetail) obj;
		if (id != other.id)
			return false;
		return true;
	}



	
		
		
		

}
