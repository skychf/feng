package com.skychf.feng.repository;

import com.skychf.feng.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comments, Integer> {
}
