package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		private String type;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String phone;
		private String description;
		@Column(name="company_url")
		private String companyUrl;
		
		private Boolean active;
		
		@OneToMany(mappedBy="comp")
		private List<Employee> employees;
		
		@JsonIgnore
		@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
		@JoinTable(name="owner",
			joinColumns=@JoinColumn(name="company_id"),
			inverseJoinColumns=@JoinColumn(name="user_detail_id"))
		private List<UserDetail> owners;
		
		@JsonIgnore
//		@JsonBackReference(value="projectToCompany")
		@OneToMany(mappedBy="company")
		private List<Project> projects;
		
		@JsonIgnore
		@OneToMany(mappedBy="company")
		private List<InventoryItem> inventoryItems;
		
		
		//Constructors
		
		public Company() {
			super();
		}

		
		

		public Company(int id, String name, String type, String address, String phone, String description,
				String companyUrl, Boolean active) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.phone = phone;
			this.description = description;
			this.companyUrl = companyUrl;
			this.active = active;
		}

		public Company(int id, String name, String type, String address, String city, String state, String zip, String phone, String description,
				String companyUrl, List<Employee> employees) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phone = phone;
			this.description = description;
			this.companyUrl = companyUrl;
			this.employees = employees;
		}

		@Override
		public String toString() {
			return "Company [id=" + id + ", name=" + name + ", type=" + type + ", address=" + address + ", phone="
					+ phone + ", description=" + description + ", companyUrl=" + companyUrl + ", active=" + active
					+ "]";
		}

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		

		public String getCity() {
			return city;
		}




		public void setCity(String city) {
			this.city = city;
		}




		public String getState() {
			return state;
		}




		public void setState(String state) {
			this.state = state;
		}




		public String getZip() {
			return zip;
		}




		public void setZip(String zip) {
			this.zip = zip;
		}




		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCompanyUrl() {
			return companyUrl;
		}

		public void setCompanyUrl(String companyUrl) {
			this.companyUrl = companyUrl;
		}
		
		

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}
		
		

		public List<UserDetail> getOwners() {
			return owners;
		}

		public void setOwners(List<UserDetail> owners) {
			this.owners = owners;
		}
		
		

		public List<Project> getProjects() {
			return projects;
		}

		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}

		


		public List<InventoryItem> getInventoryItems() {
			return inventoryItems;
		}




		public void setInventoryItems(List<InventoryItem> inventoryItems) {
			this.inventoryItems = inventoryItems;
		}




		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((active == null) ? 0 : active.hashCode());
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((companyUrl == null) ? 0 : companyUrl.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((employees == null) ? 0 : employees.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((owners == null) ? 0 : owners.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((projects == null) ? 0 : projects.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Company other = (Company) obj;
			if (active == null) {
				if (other.active != null)
					return false;
			} else if (!active.equals(other.active))
				return false;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (companyUrl == null) {
				if (other.companyUrl != null)
					return false;
			} else if (!companyUrl.equals(other.companyUrl))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (employees == null) {
				if (other.employees != null)
					return false;
			} else if (!employees.equals(other.employees))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (owners == null) {
				if (other.owners != null)
					return false;
			} else if (!owners.equals(other.owners))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (projects == null) {
				if (other.projects != null)
					return false;
			} else if (!projects.equals(other.projects))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		
		
		

}
