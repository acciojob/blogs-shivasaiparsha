package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="User")
public class User{


    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    private String userName;
    private String Password;
    private String firstName="test";
    private String lastdName="test";



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> blogList;
    public User(){

    }

   public User( String userName, String Password)
   {
       this.userId=userId;
       this.userName=userName;
       this.Password=Password;
   }

    public User(int userId, String userName, String Password, String firstName, String lastName, List<Blog> blogList) {
        this.userId=userId;
        this.userName=userName;
        this.Password=Password;
        this.firstName=firstName;
        this.lastdName=lastName;
        this.blogList=blogList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastdName() {
        return lastdName;
    }

    public void setLastdName(String lastdName) {
        this.lastdName = lastdName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}