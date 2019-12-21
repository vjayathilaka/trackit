package com.myproject.trackit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	List<Task> findByIdAndStatus(Long projectId, String status);

	List<Project> findByConstructorId(String userId); // select * from projects where constructor_id=userId

	List<Project> findByClientId(String clientId);// select * from project where client_id=clientId

	List<Project> findByEngineerId(String engineerId);
}
