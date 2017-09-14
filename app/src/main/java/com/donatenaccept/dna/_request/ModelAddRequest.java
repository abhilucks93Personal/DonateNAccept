package com.donatenaccept.dna._request;

/**
 * Created by abhi on 31/08/17.
 */

class ModelAddRequest {

    private String user_id;

    private String blood_group_id;

    private String request_type;

    private String request_location;

    private String request_lat;

    private String request_long;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBlood_group_id() {
        return blood_group_id;
    }

    public void setBlood_group_id(String blood_group_id) {
        this.blood_group_id = blood_group_id;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getRequest_location() {
        return request_location;
    }

    public void setRequest_location(String request_location) {
        this.request_location = request_location;
    }

    public String getRequest_lat() {
        return request_lat;
    }

    public void setRequest_lat(String request_lat) {
        this.request_lat = request_lat;
    }

    public String getRequest_long() {
        return request_long;
    }

    public void setRequest_long(String request_long) {
        this.request_long = request_long;
    }
}
