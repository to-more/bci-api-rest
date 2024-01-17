package com.bci.apirest.mappers;

import com.bci.apirest.dtos.UserDto;
import com.bci.apirest.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Optional;
import java.util.UUID;

@Mapper(
    uses = PhoneMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UserMapper {

    @Mapping(expression = "java(Boolean.TRUE)", target = "active")
    @Mapping(expression = "java(java.util.UUID.randomUUID().toString())", target = "id")
    @Mapping(expression = "java(user.getId())", target = "token")
    @Mapping(expression = "java(new java.util.Date())", target = "created")
    User dtoToModelAux(UserDto userDto);
    default Optional<User> dtoToModel(UserDto userDto){
        return Optional.ofNullable(dtoToModelAux(userDto));
    }
}
