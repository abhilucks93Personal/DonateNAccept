package com.donatenaccept.dna._memories;

import com.donatenaccept.dna.login.ModelRegistration;

import java.util.ArrayList;

/**
 * Created by abhi on 01/08/17.
 */

public class ResponseModelMemories {

    private String code;

    private String message;

    private ArrayList<ResponseModelMemoriesData> data;

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

    public ArrayList<ResponseModelMemoriesData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseModelMemoriesData> data) {
        this.data = data;
    }


}
