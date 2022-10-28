package com.bsc.shastram.commons.util.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bsc.shastram.commons.base.BaseIDEntity;

@Component
public class ResponseEntityUtil {

	
	@Autowired
    DTOUtil dtoUtil;

    public  Object convertToDtoObject(BaseIDEntity entity, Class c) {
     return dtoUtil.convertToDtoObject(entity,c);
    }

    public JSONArray convertToDTOJsonArray(List<?> entities, Class c)
    {
        return dtoUtil.convertToDtoJsonArray(entities,c);
    }

    public static ResponseEntity<String> build(int code, String data)  {
        return buildInternal(code, data);
    }

    public static ResponseEntity<String> build(int code, JSONObject data)  {
        return buildInternal(code, data);
    }

    public static ResponseEntity<String> build(int code, JSONArray data)  {
        return buildInternal(code, data);

    }

    private static ResponseEntity<String> buildInternal(int code, Object data)  {
        JSONObject res = new JSONObject();
        try {
            res.put("status", code);
            res.put("data", data);
            ResponseEntity<String> re = ResponseEntity.status(code).body(res.toString());
            return re;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return getUnknownError(e.getMessage());
        }
    }


    public static ResponseEntity<String> unauthorised(Object data) throws JSONException {
        JSONObject res = new JSONObject();
        res.put("status", 401);
        res.put("data", data = data == null ? "Unauthorized Access":data);
        ResponseEntity<String> re = ResponseEntity.status(401).body(res.toString());
        return re;

    }
    public static ResponseEntity<String> forbidden(Object data) throws JSONException {
        JSONObject res = new JSONObject();
        res.put("status", 403);
        res.put("data", data = data == null ? "Forbidden Access":data);
        ResponseEntity<String> re = ResponseEntity.status(403).body(res.toString());
        return re;

    }

    private  static ResponseEntity<String> getUnknownError(String message)
    {
        JSONObject res = new JSONObject();

        try {
            res.put("status", 500);
            res.put("error","unknown | "+message);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ResponseEntity<String> re = ResponseEntity.status(500).body(res.toString());
        return re;
    }
}
