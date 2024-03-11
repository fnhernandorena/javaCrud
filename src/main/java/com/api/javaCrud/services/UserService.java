package com.api.javaCrud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.javaCrud.models.UserModel;
import com.api.javaCrud.repositories.IUserRepository;

@Service
public class UserService {

@Autowired
IUserRepository userRepository;

public ArrayList<UserModel> getUsers(){
    return (ArrayList<UserModel>) userRepository.findAll();
}

public UserModel saveUser(UserModel user){
  if (user!=null) {
    return userRepository.save(user);
  }  return null;
}

public Optional<UserModel> getById(Long id){
   if (id!=null) {
    return userRepository.findById(id);
   } return null;
}

public UserModel updateById(UserModel request, Long id) {
    if (userRepository!= null && id!= null) {
        UserModel user = userRepository.findById(id).get();
        if (user!= null) {
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            userRepository.save(user);

            return user;
        }
    }

    return null;
}

public Boolean deleteUser(Long id){
if (id!=null) {
try{
userRepository.deleteById(id);
return true;
    } catch (Exception e){
    return false;
    }    
}   return false; 
}

}
