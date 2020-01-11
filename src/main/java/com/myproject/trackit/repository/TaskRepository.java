package com.myproject.trackit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByProjectIdAndStatus(Long projectId, String status);
	
	List<Task> getByAssignee_id(Long userId);

}
