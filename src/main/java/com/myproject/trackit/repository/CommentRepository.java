package com.myproject.trackit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.trackit.domain.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
