package com.singh.userservice.serviceImplementation;

import com.singh.userservice.dto.UserAuthDTO;
import com.singh.userservice.dto.UserDTO;
import com.singh.userservice.entity.UserDAO;
import com.singh.userservice.repository.UserRepo;
import com.singh.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
//import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDTO login(UserAuthDTO userAuthDTO) {
        if (userRepo.existsByUsernameAndPassword(userAuthDTO.getUsername(), userAuthDTO.getPassword())) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(userAuthDTO.getUsername());
            userDTO.setPassword(userAuthDTO.getPassword());
            return userDTO;
        }
        else {
            throw new RuntimeException("Invalid username or password");
        }
    }


    @Override
    public UserDTO register(UserDTO userDTO) {
        if(userRepo.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if(userRepo.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(userDTO.getUsername());
        userDAO.setEmail(userDTO.getEmail());
        userDAO.setPassword(userDTO.getPassword());
        userDAO.setFirstName(userDTO.getFirstName());
        userDAO.setLastName(userDTO.getLastName());
        userDAO.setPhone(userDTO.getPhone());

        var user = userRepo.save(userDAO);
        return mapToDTO(user);
    }

    public UserDTO mapToDTO(UserDAO user) {

        UserDTO userDTO = new UserDTO();
//        userDTO.setI(user.getId());
        userDTO.setEmail(user.getUsername());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhone(user.getPhone());

        return userDTO;
    }
}
