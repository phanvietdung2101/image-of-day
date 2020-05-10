package com.yyy.controller;

import com.yyy.model.Comment;
import com.yyy.model.Image;
import com.yyy.service.ICommentService;
import com.yyy.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageController {
    @Autowired
    IImageService imageService;

    @Autowired
    ICommentService commentService;

    @RequestMapping(value = "/index")
    public ModelAndView showImage(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("image",new Image());
        return modelAndView;
    }

    @RequestMapping(value = "/get-comments")
    public ModelAndView showImageWithComment(@RequestParam("imageUrl") String imageUrl){
        ModelAndView modelAndView = new ModelAndView("index");
        Image image = imageService.findImageByImgUrl(imageUrl);
        List<Comment> comments = new ArrayList<>();
        if(image == null){
            image = new Image();
            image.setImgUrl(imageUrl);
            imageService.save(image);
        } else {
            comments = commentService.findCommentListByImage(image);
        }
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }


}
