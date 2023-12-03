package com.cac.Homebanking3.services;

import com.cac.Homebanking3.exceptions.UserNotExistsException;
import com.cac.Homebanking3.mappers.UserMapper;
import com.cac.Homebanking3.models.User;
import com.cac.Homebanking3.models.dtos.UserDTO;
import com.cac.Homebanking3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    // el servicio tiene que inyectar una instancia del Repositori
    @Autowired
    private UserRepository repository;

    //public UserService(UserRepository repository){
    //  this.repository=repository;

    //}
    public List<UserDTO> getUsers() {
        List<User> users = repository.findAll();
        List<UserDTO> userDtos = users.stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
        return userDtos;
    }

    public UserDTO createUser(UserDTO userDTO) {

        User userValidated = validateUserByEmail( userDTO);
        if(userValidated ==null){
        User userSaved = repository.save(UserMapper.dtoToUser(userDTO));
        return UserMapper.userToDto(userSaved);}
        else {
            throw new UserNotExistsException("usuario con mail"+userDTO.getEmail()+"ya existe");
        }
    }

    public UserDTO getUserById(Long id) {
        User entity = repository.findById(id).get();
        return UserMapper.userToDto(entity);
    }

    public void deleteUser(Long id) {
        if (getUserById(id) != null) {
            repository.deleteById(id);
        } else {
            throw new UserNotExistsException("El usuario selecionado no existe");
        }

    }


    public UserDTO upDateUser(Long id, UserDTO dto) {
        User userToModify =repository.findById(id).get();
        if (repository.existsById(id)) {
        if(dto.getPassword() !=null){userToModify.setPassword(dto.getPassword());}
        if(dto.getDni() !=null){userToModify.setDni(dto.getDni());}
        if(dto.getSurname() !=null){userToModify.setSurname(dto.getSurname());}
        if(dto.getUsername() !=null){userToModify.setUsername(dto.getUsername());}
        if(dto.getEmail() !=null){userToModify.setEmail(dto.getEmail());}

        User userModified= repository.save(userToModify);

        return UserMapper.userToDto(userModified);

        }
        return null;
    }
    //validacion de usuario unico  en el modelo de negocios

    public User validateUserByEmail(UserDTO dto){
       return repository.findByEmail(dto.getEmail());


    }
}