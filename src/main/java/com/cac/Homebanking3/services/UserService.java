package com.cac.Homebanking3.services;

import com.cac.Homebanking3.mappers.UserMapper;
import com.cac.Homebanking3.models.User;
import com.cac.Homebanking3.models.dtos.UserDTO;
import com.cac.Homebanking3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserDTO> getUsers(){
        List<User> users=repository.findAll();
        List<UserDTO> userDtos=users.stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
        return userDtos;
    }
    public UserDTO createUser(UserDTO userDTO){

       User user=repository.save(UserMapper.dtoToUser(userDTO));

        return UserMapper.userToDto(user);
    }
    public UserDTO getUserById(Long id){
        User entity= repository.findById(id).get();
        return UserMapper.userToDto(entity);
    }

}
