package com.singh.userservice.service;

import com.singh.userservice.dto.UserAuthDTO;
import com.singh.userservice.dto.UserDTO;

public interface UserService {

    UserDTO login(UserAuthDTO userAuthDTO);

    UserDTO register(UserDTO userDTO);


}
