package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer blogId;

    private String title;
    private String content;
    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    @JoinColumn
    private List<Image> imageList;

    public Blog(){

    }

    public Blog(User user,String title, String content){
        this.user=user;
        this.title=title;
        this.content=content;
    }
    public Blog(Integer blogId, String title, String content, User user, List<Image> imageList)
    {
        this.user=user;
        this.title=title;
        this.content=content;
        this.imageList=imageList;
        this.blogId=blogId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}

