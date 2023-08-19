package com.driver.services;

import com.driver.controller.ImageController;
import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
          Image image = new Image(blog, description, dimensions);
          blog.getImageList().add(image);
          blogRepository2.save(blog);
          return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions
        // that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();

        String imageDimensions=image.getDimensions();

        String imageDim[]=imageDimensions.split("X");
        String screenDim[]=screenDimensions.split("X");

        int imageWidth=Integer.parseInt(imageDim[0]);
        int imageHeight=Integer.parseInt(imageDim[1]);

        int screenWidth=Integer.parseInt(screenDim[0]);
        int screenHeight=Integer.parseInt(screenDim[1]);

        int w=screenWidth/imageWidth;
        int h=screenHeight/imageHeight;
        return w*h;
    }
}
