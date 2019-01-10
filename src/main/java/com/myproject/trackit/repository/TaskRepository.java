package com.myproject.trackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
