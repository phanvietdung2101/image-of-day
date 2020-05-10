package com.yyy.service.impl;

import com.yyy.model.Comment;
import com.yyy.model.Image;
import com.yyy.repository.ICommentRepository;
import com.yyy.repository.IImageRepository;
import com.yyy.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ImageService implements IImageService {
    @Autowired
    IImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public Image findById(Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if(optionalImage.isPresent()){
            return optionalImage.get();
        }
        throw new RuntimeException("Khong ton tai anh nay");
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image findImageByImgUrl(String imageUrl) {
        return imageRepository.findImageByImgUrl(imageUrl);
    }
}
