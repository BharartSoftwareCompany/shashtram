package com.bsc.shastram.commons.util;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bsc.shastram.commons.base.BaseIDEntity;
import com.bsc.shastram.commons.base.DTO;

@Component
public class ModelUtil {
	
	
	@Autowired
    private ModelMapper modelMapper;
	
	public  DTO convertToDto(BaseIDEntity entity) {
	    DTO dto = modelMapper.map(entity, DTO.class);
	    return dto;
	}
	
	public BaseIDEntity convertToEntity(DTO postDto, Class  c) throws ParseException {

		BaseIDEntity entity = (BaseIDEntity) modelMapper.map(postDto, c);
	    return entity;
	}

}
