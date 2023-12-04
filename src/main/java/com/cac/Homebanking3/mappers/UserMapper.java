package com.cac.Homebanking3.mappers;
import com.cac.Homebanking3.models.User;
import com.cac.Homebanking3.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    //metodos para transformar objetos
    public static User dtoToUser(UserDTO dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setSurname(dto.getSurname());
        user.setDni(dto.getDni());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }
        public static UserDTO userToDto(User user){

        UserDTO dto=new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setSurname(user.getSurname());
        dto.setDni((user.getDni()));
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }

}
