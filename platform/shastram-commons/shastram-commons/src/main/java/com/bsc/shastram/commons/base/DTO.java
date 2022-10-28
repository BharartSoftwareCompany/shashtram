package com.bsc.shastram.commons.base;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.bsc.shastram.commons.util.DateUtil;
import com.google.gson.Gson;

import lombok.Data;
import lombok.EqualsAndHashCode;




@Data
@EqualsAndHashCode(callSuper=false)
public class DTO {

	
	


    protected Long createdTimestamp;
    protected Long updatedTimestamp;
    protected Date createdOn;
    protected Date updatedOn;
    protected boolean active = true;



    public DTO(){

        Date date = DateUtil.getCurrentDateTimeUTC();
        updatedOn = date;
        createdOn =date;
        createdTimestamp =  date.getTime();
        updatedTimestamp =date.getTime();
    }

    public String toJsonString()  {
        Gson gson = new Gson();
        return gson.toJson(this);


    }
    public JSONObject toJson()  {
        Gson gson = new Gson();
        try {
            return new JSONObject( gson.toJson(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }
}
