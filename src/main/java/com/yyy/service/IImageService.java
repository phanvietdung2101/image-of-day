package com.yyy.service;

import com.yyy.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> findAll();
    Image findById(Long id);
    void save(Image image);
    void remove(Long id);
    Image findImageByImgUrl(String imageUrl);
}
