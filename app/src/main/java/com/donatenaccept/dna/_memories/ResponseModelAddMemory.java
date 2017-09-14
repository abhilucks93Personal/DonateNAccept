package com.donatenaccept.dna._memories;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by abhi on 01/08/17.
 */

public class ResponseModelAddMemory implements Serializable {

    private String code;

    private String message;

    private ResponseModelMemoriesData data;

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

    public ResponseModelMemoriesData getData() {
        return data;
    }

    public void setData(ResponseModelMemoriesData data) {
        this.data = data;
    }


}
