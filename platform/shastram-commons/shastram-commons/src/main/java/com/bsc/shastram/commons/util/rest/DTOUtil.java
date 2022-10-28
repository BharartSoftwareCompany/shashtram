package com.bsc.shastram.commons.util.rest;

import java.util.List;

import org.json.JSONArray;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.bsc.shastram.commons.base.BaseIDEntity;
import com.bsc.shastram.commons.base.DTO;

@Component
public class DTOUtil {
	
	
	
	  public  Object
	    convertToDtoObject(BaseIDEntity entity, Class c) {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(entity, c);
	    }

	    public JSONArray convertToDtoJsonArray(List<?> entities, Class c) {

	        ModelMapper modelMapper = new ModelMapper();

	        JSONArray array = new JSONArray();
	        for(Object e: entities)
	        {
	            array.put(((DTO)modelMapper.map(e, c)).toJson());
	        }

	        return  array;
	    }

}
