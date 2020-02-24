package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="customer_id")
		private Customer customer;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="company_id")
		private Company company;
		
		
		@OneToMany(mappedBy="proj")
		List<Task> tasks;

		//Constructors
		
		public Project() {
			super();
		}

		public Project(int id, String name, Customer cust, Company comp) {
			super();
			this.id = id;
			this.name = name;
			this.customer = cust;
			this.company = comp;
		}
		
		

		public Project(int id, String name, Customer cust, Company comp, List<Task> tasks) {
			super();
			this.id = id;
			this.name = name;
			this.customer = cust;
			this.company = comp;
			this.tasks = tasks;
		}
		

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
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

		public Customer getCust() {
			return customer;
		}

		public void setCust(Customer cust) {
			this.customer = cust;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company comp) {
			this.company = comp;
		}
		
		

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", cust=" + customer + ", comp=" + company + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((company == null) ? 0 : company.hashCode());
			result = prime * result + ((customer == null) ? 0 : customer.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			Project other = (Project) obj;
			if (company == null) {
				if (other.company != null)
					return false;
			} else if (!company.equals(other.company))
				return false;
			if (customer == null) {
				if (other.customer != null)
					return false;
			} else if (!customer.equals(other.customer))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
		

}
