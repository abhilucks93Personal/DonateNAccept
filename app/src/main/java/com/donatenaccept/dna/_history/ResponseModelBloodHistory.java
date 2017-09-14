package com.donatenaccept.dna._history;

import com.donatenaccept.dna._memories.ResponseModelMemoriesData;

import java.util.ArrayList;

/**
 * Created by abhi on 01/08/17.
 */

public class ResponseModelBloodHistory {

    private String code;

    private String message;

    private ArrayList<ResponseModelBloodHistoryData> data;

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

    public ArrayList<ResponseModelBloodHistoryData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseModelBloodHistoryData> data) {
        this.data = data;
    }

}
