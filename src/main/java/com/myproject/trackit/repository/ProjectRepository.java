package com.myproject.trackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
