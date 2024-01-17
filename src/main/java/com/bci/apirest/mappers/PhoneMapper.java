package com.bci.apirest.mappers;

import com.bci.apirest.dtos.PhoneDto;
import com.bci.apirest.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PhoneMapper {

    Phone dtoToModel(PhoneDto phoneDto);
}
