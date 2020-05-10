package com.yyy.service.impl;

import com.yyy.model.Comment;
import com.yyy.model.Image;
import com.yyy.repository.ICommentRepository;
import com.yyy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository commentRepository;


    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()){
            return optionalComment.get();
        }
        throw new RuntimeException("Khong tim thay comment");
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findCommentListByImage(Image image) {
        return commentRepository.findAllByImage(image);
    }

}
