package com.example.webshop.domain.user.dto;

import com.example.webshop.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDTO (UserDTO userDTO);
    UserDTO toDTO(User user);
}
