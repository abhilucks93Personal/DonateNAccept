package com.donatenaccept.dna._notifications;

import java.util.ArrayList;

/**
 * Created by abhi on 01/08/17.
 */

public class ResponseModelNotification {
    private String code;

    private String message;

    private ArrayList<ResponseModelNotificationData> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ResponseModelNotificationData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseModelNotificationData> data) {
        this.data = data;
    }
}
