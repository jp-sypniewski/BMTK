package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		private String type;
		private String address;
		private String phone;
		private String description;
		@Column(name="company_url")
		private String companyUrl;
		
		@OneToMany(mappedBy="comp")
		private List<Employee> employees;
		
		
		
		//Constructors
		
		public Company() {
			super();
		}

		public Company(int id, String name, String type, String address, String phone, String description,
				String companyUrl) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.phone = phone;
			this.description = description;
			this.companyUrl = companyUrl;
		}
		
		

		public Company(int id, String name, String type, String address, String phone, String description,
				String companyUrl, List<Employee> employees) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.phone = phone;
			this.description = description;
			this.companyUrl = companyUrl;
			this.employees = employees;
		}

		@Override
		public String toString() {
			return "Company [id=" + id + ", name=" + name + ", type=" + type + ", address=" + address + ", phone="
					+ phone + ", description=" + description + ", companyUrl=" + companyUrl + "]";
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((companyUrl == null) ? 0 : companyUrl.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
		
		

}
