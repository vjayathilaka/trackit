package com.myproject.trackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{

}
