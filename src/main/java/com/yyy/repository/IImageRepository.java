package com.yyy.repository;

import com.yyy.model.Comment;
import com.yyy.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IImageRepository extends CrudRepository<Image,Long> {
    Image findImageByImgUrl(String imageUrl);
}
