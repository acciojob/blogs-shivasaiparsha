package com.driver.models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer imageId;

   @ManyToOne
    @JoinColumn
    private Blog blog;
   private String descrption;
   private String dimensions;

   public Image(){

   }

   public Image(Blog blog, String descrption, String dimensions)
   {
       this.blog=blog;
       this.descrption=descrption;
       this.dimensions=dimensions;
   }

   public Image(Integer imageId, String descrption, String dimensions, Blog blog){
       this.imageId=imageId;
       this.descrption=descrption;
       this.dimensions=dimensions;
       this.blog=blog;
   }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}