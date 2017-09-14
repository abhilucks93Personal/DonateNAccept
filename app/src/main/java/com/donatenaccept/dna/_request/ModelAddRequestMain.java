package com.donatenaccept.dna._request;

import com.donatenaccept.dna.login.ModelRegistration;

/**
 * Created by abhi on 31/08/17.
 */

public class ModelAddRequestMain {

    private String code;

    private String message;

    private ModelAddRequest data;

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

    public ModelAddRequest getData() {
        return data;
    }

    public void setData(ModelAddRequest data) {
        this.data = data;
    }
}


