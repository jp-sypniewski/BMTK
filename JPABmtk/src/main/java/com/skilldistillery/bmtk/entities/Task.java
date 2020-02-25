package com.skilldistillery.bmtk.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
		private String dueDate;
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
		private String startDate;
		@Column(name="complete_date")
		private String completeDate;
		
		@Enumerated(EnumType.STRING)
		private Status status;
		
		private String type;
		private String priority;
		@Column(name="payment_detail")
		private String paymentDetail;
		
		private Double price;
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="project_id")
		private Project project;
		
		public Task() {
			super();
		}
		public Task(int id, String name, String description, String dueDate, boolean paid, Date createdAt,
				Date updatedAt, boolean template, String startDate, String completeDate, Status status,
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
		
		



		public Task(int id, String name, String description, String dueDate, boolean paid, Date createdAt,
				Date updatedAt, boolean template, String startDate, String completeDate, Status status,
				String type, String priority, String paymentDetail, double price, Project proj) {
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
			this.project = proj;
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

		public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
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

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getCompleteDate() {
			return completeDate;
		}

		public void setCompleteDate(String completeDate) {
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
		
		
		
		
		
		
		
		
		

}
