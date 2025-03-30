package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.RegisterRequest;
import com.project.shopapp.DTO.UserDTO;
import com.project.shopapp.Model.User;

public interface IUserService {
    List<User> getAllUser();

    User getByUserId(long id) throws Exception;

    User createUser(RegisterRequest registerRequest) throws Exception;

    User updateUser(UserDTO userDTO, long id) throws Exception;

    void deleteUser(long id) throws Exception;

}
