package com.skilldistillery.bmtk.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
		private UserDetail userDetail;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="company_id")
		private Company comp;

		private Boolean active;
		
		@JsonIgnore
		@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
		@JoinTable(name="employee_has_task",
			joinColumns=@JoinColumn(name="employee_id"),
			inverseJoinColumns=@JoinColumn(name="task_id"))
		private List<Task> tasks;
		
		
		public Employee() {
			super();
		}


		public Employee(int id, UserDetail userDetail, Company comp, Boolean active) {
			super();
			this.id = id;
			this.userDetail = userDetail;
			this.comp = comp;
			this.active = active;
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

		public UserDetail getUserDetail() {
			return userDetail;
		}

		public void setUserDetail(UserDetail uDetail) {
			this.userDetail = uDetail;
		}

		public Company getComp() {
			return comp;
		}

		public void setComp(Company comp) {
			this.comp = comp;
		}

		public List<Task> getTasks() {
			return tasks;
		}


		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}


		@Override
		public String toString() {
			return "Employee [id=" + id + ", userDetail=" + userDetail + ", comp=" + comp + ", active=" + active + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comp == null) ? 0 : comp.hashCode());
			result = prime * result + id;
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
			Employee other = (Employee) obj;
			if (comp == null) {
				if (other.comp != null)
					return false;
			} else if (!comp.equals(other.comp))
				return false;
			if (id != other.id)
				return false;
			if (userDetail == null) {
				if (other.userDetail != null)
					return false;
			} else if (!userDetail.equals(other.userDetail))
				return false;
			return true;
		}
		
		

}
