package com.skilldistillery.bmtk.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	
	//Fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		private String description;
		
		@Column(name="due_date")
		private LocalDate dueDate;
		
		private Boolean paid;
		
		@CreationTimestamp
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="created_at")
		private Date createdAt;
		
		@UpdateTimestamp
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="updated_at")
		private Date updatedAt;
		
		private Boolean template;
		
		@Column(name="start_date")
		private LocalDate startDate;
		
		@Column(name="complete_date")
		private LocalDate completeDate;
		
		@Enumerated(EnumType.STRING)
		private Status status;
		
		private String type;
		private String priority;
		@Column(name="payment_detail")
		private String paymentDetail;
		
		private Double price;
		
		private Boolean active;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="project_id")
		private Project project;
		
		@ManyToMany(cascade= {CascadeType.REMOVE})
		@JoinTable(name="employee_has_task",
			joinColumns=@JoinColumn(name="task_id"),
			inverseJoinColumns=@JoinColumn(name="employee_id"))
		private List<Employee> employees;
		
		public Task() {
			super();
		}
		public Task(int id, String name, String description, LocalDate dueDate, boolean paid, Date createdAt,
				Date updatedAt, boolean template, LocalDate startDate, LocalDate completeDate, Status status,
				String type, String priority, String paymentDetail, double price) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.dueDate = dueDate;
			this.paid = paid;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.template = template;
			this.startDate = startDate;
			this.completeDate = completeDate;
			this.status = status;
			this.type = type;
			this.priority = priority;
			this.paymentDetail = paymentDetail;
			this.price = price;
		}
		
		
		public Task(int id, String name, String description, LocalDate dueDate, Boolean paid, Date createdAt,
				Date updatedAt, Boolean template, LocalDate startDate, LocalDate completeDate, Status status, String type,
				String priority, String paymentDetail, Double price, Boolean active, Project project) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.dueDate = dueDate;
			this.paid = paid;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.template = template;
			this.startDate = startDate;
			this.completeDate = completeDate;
			this.status = status;
			this.type = type;
			this.priority = priority;
			this.paymentDetail = paymentDetail;
			this.price = price;
			this.active = active;
			this.project = project;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public Boolean isPaid() {
			return paid;
		}

		public void setPaid(Boolean paid) {
			this.paid = paid;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Boolean isTemplate() {
			return template;
		}

		public void setTemplate(Boolean template) {
			this.template = template;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getCompleteDate() {
			return completeDate;
		}

		public void setCompleteDate(LocalDate completeDate) {
			this.completeDate = completeDate;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getPaymentDetail() {
			return paymentDetail;
		}

		public void setPaymentDetail(String paymentDetail) {
			this.paymentDetail = paymentDetail;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Project getProject() {
			return project;
		}

		public void setProject(Project proj) {
			this.project = proj;
		}
		
		
		public List<Employee> getEmployees() {
			return employees;
		}
		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
					+ ", paid=" + paid + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", template="
					+ template + ", startDate=" + startDate + ", completeDate=" + completeDate + ", status=" + status
					+ ", type=" + type + ", priority=" + priority + ", paymentDetail=" + paymentDetail + ", price="
					+ price + ", active=" + active + ", project=" + project + "]";
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
			Task other = (Task) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
		
		
		
		
		
		
		
		
		
		

}
