package com.donatenaccept.dna.login;

import com.donatenaccept.dna.retrofit.BaseModel;

/**
 * Created by abhi on 29/08/17.
 */

public class ModelRegistration extends BaseModel {

    private String registration_type;
    private String full_name;
    private String user_mobile;
    private String user_email;
    private String password;
    private String user_age;
    private String user_blood_group_id;
    private String user_blood_group;
    private String user_lat;
    private String user_long;
    private String device_type;
    private String device_token;

    public String getRegistration_type() {
        return registration_type;
    }

    public void setRegistration_type(String registration_type) {
        this.registration_type = registration_type;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_blood_group_id() {
        return user_blood_group_id;
    }

    public void setUser_blood_group_id(String user_blood_group_id) {
        this.user_blood_group_id = user_blood_group_id;
    }

    public String getUser_blood_group() {
        if (user_blood_group == null)
            user_blood_group = "";
        return user_blood_group;
    }

    public void setUser_blood_group(String user_blood_group) {
        this.user_blood_group = user_blood_group;
    }

    public String getUser_lat() {
        return user_lat;
    }

    public void setUser_lat(String user_lat) {
        this.user_lat = user_lat;
    }

    public String getUser_long() {
        return user_long;
    }

    public void setUser_long(String user_long) {
        this.user_long = user_long;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }
}
