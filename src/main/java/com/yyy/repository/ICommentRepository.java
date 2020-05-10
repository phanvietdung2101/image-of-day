package com.yyy.repository;

import com.yyy.model.Comment;
import com.yyy.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> findAllByImage(Image image);
}
