package com.skilldistillery.bmtk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
		private Customer cust;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="company_id")
		private Company comp;

		//Constructors
		
		public Project() {
			super();
		}

		public Project(int id, String name, Customer cust, Company comp) {
			super();
			this.id = id;
			this.name = name;
			this.cust = cust;
			this.comp = comp;
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
			return cust;
		}

		public void setCust(Customer cust) {
			this.cust = cust;
		}

		public Company getComp() {
			return comp;
		}

		public void setComp(Company comp) {
			this.comp = comp;
		}

		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", cust=" + cust + ", comp=" + comp + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comp == null) ? 0 : comp.hashCode());
			result = prime * result + ((cust == null) ? 0 : cust.hashCode());
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
			if (comp == null) {
				if (other.comp != null)
					return false;
			} else if (!comp.equals(other.comp))
				return false;
			if (cust == null) {
				if (other.cust != null)
					return false;
			} else if (!cust.equals(other.cust))
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
