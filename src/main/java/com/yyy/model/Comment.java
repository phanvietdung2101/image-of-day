package com.yyy.model;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    private long id;

    private String author;
    private String feedback;

    @OneToOne(targetEntity = Rate.class)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @ManyToOne(targetEntity = Image.class)
    private Image image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
