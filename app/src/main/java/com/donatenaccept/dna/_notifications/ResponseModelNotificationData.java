package com.donatenaccept.dna._notifications;

/**
 * Created by abhi on 01/08/17.
 */

public class ResponseModelNotificationData {

    private String image_url;
    private String description;
    private int type;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
