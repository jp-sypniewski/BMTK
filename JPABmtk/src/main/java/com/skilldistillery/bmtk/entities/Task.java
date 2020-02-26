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
		
		private Boolean active;
		
		
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
		
		
		public Task(int id, String name, String description, String dueDate, Boolean paid, Date createdAt,
				Date updatedAt, Boolean template, String startDate, String completeDate, Status status, String type,
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
			result = prime * result + ((active == null) ? 0 : active.hashCode());
			result = prime * result + ((completeDate == null) ? 0 : completeDate.hashCode());
			result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((paid == null) ? 0 : paid.hashCode());
			result = prime * result + ((paymentDetail == null) ? 0 : paymentDetail.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((priority == null) ? 0 : priority.hashCode());
			result = prime * result + ((project == null) ? 0 : project.hashCode());
			result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			result = prime * result + ((template == null) ? 0 : template.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
			if (active == null) {
				if (other.active != null)
					return false;
			} else if (!active.equals(other.active))
				return false;
			if (completeDate == null) {
				if (other.completeDate != null)
					return false;
			} else if (!completeDate.equals(other.completeDate))
				return false;
			if (createdAt == null) {
				if (other.createdAt != null)
					return false;
			} else if (!createdAt.equals(other.createdAt))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (dueDate == null) {
				if (other.dueDate != null)
					return false;
			} else if (!dueDate.equals(other.dueDate))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (paid == null) {
				if (other.paid != null)
					return false;
			} else if (!paid.equals(other.paid))
				return false;
			if (paymentDetail == null) {
				if (other.paymentDetail != null)
					return false;
			} else if (!paymentDetail.equals(other.paymentDetail))
				return false;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (priority == null) {
				if (other.priority != null)
					return false;
			} else if (!priority.equals(other.priority))
				return false;
			if (project == null) {
				if (other.project != null)
					return false;
			} else if (!project.equals(other.project))
				return false;
			if (startDate == null) {
				if (other.startDate != null)
					return false;
			} else if (!startDate.equals(other.startDate))
				return false;
			if (status != other.status)
				return false;
			if (template == null) {
				if (other.template != null)
					return false;
			} else if (!template.equals(other.template))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			if (updatedAt == null) {
				if (other.updatedAt != null)
					return false;
			} else if (!updatedAt.equals(other.updatedAt))
				return false;
			return true;
		}
		
		
		
		
		
		
		
		
		

}
