package com.skilldistillery.bmtk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@OneToOne
		@JoinColumn(name="user_detail_id")
		private UserDetail uDetail;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="company_id")
		private Company comp;

		public Employee() {
			super();
		}

		public Employee(int id, UserDetail uDetail, Company comp) {
			super();
			this.id = id;
			this.uDetail = uDetail;
			this.comp = comp;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public UserDetail getuDetail() {
			return uDetail;
		}

		public void setuDetail(UserDetail uDetail) {
			this.uDetail = uDetail;
		}

		public Company getComp() {
			return comp;
		}

		public void setComp(Company comp) {
			this.comp = comp;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", uDetail=" + uDetail + ", comp=" + comp + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comp == null) ? 0 : comp.hashCode());
			result = prime * result + id;
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
			Employee other = (Employee) obj;
			if (comp == null) {
				if (other.comp != null)
					return false;
			} else if (!comp.equals(other.comp))
				return false;
			if (id != other.id)
				return false;
			if (uDetail == null) {
				if (other.uDetail != null)
					return false;
			} else if (!uDetail.equals(other.uDetail))
				return false;
			return true;
		}
		
		

}
