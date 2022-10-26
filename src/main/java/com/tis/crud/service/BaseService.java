package com.tis.crud.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

abstract class BaseService<T,B>{
 
	public static final ModelMapper modelMapper;
	
	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
	} 
	
	abstract T convertEntityToDto(B t);
	abstract B convertDtoToEntity(T t);
	
}
