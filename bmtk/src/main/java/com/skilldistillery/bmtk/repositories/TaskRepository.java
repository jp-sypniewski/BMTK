package com.skilldistillery.bmtk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.bmtk.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query(value = "SELECT * FROM task JOIN employee_has_task on task.id = employee_has_task.task_id "
			+ "JOIN employee on employee_has_task.employee_id = employee.id "
			+ "JOIN user_detail on employee.user_detail_id = user_detail.id "
			+ "JOIN user on user_detail.id = user.user_detail_id "
			+ "WHERE user.username = :username", nativeQuery = true)
	List<Task> findTaskByEmpUsername(@Param("username") String username);

}
