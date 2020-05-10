package com.yyy.service;

import com.yyy.model.Comment;
import com.yyy.model.Image;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    void save(Comment comment);
    void remove(Long id);

    List<Comment> findCommentListByImage(Image image);
}
