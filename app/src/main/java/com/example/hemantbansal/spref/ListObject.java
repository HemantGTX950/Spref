package com.example.hemantbansal.spref;

/**
 * Created by Hemant Bansal on 10/6/2016.
 */

public class ListObject {

    private String title;
    private String message;
    private int imageId;
    private String image;

    public ListObject(String title, String message,int imageId) {
        this.message = message;
        this.title = title;
        this.imageId=imageId;
    }
    public ListObject(String title, String message,int imageId,String image) {
        this.message = message;
        this.title = title;
        this.imageId=imageId;
        this.image=image;
    }

    public String getMessage(){
        return message;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImage() {
        return image;
    }
}
