package com.donatenaccept.dna.login;

import com.donatenaccept.dna.retrofit.BaseModel;

/**
 * Created by abhi on 29/08/17.
 */

public class ModelRegistrationMain extends BaseModel {

    private String code;

    private String message;

    private ModelRegistration data;

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

    public ModelRegistration getData() {
        return data;
    }

    public void setData(ModelRegistration data) {
        this.data = data;
    }
}
