package com.project.shopapp.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.UserDTO;
import com.project.shopapp.Model.User;
import com.project.shopapp.Repository.RoleRepository;
import com.project.shopapp.Repository.UserRepository;
import com.project.shopapp.Service.Impl.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserId(long id) throws Exception {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new Exception("id user này không tồn tại"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        try {
            roleRepository.findById(userDTO.getRoleId())
                    .orElseThrow(() -> new Exception("Mã roleid này không tồn tại"));
            User user = User.builder()
                    .phoneNumber(userDTO.getPhoneNumber())
                    .email(userDTO.getEmail())
                    .address(userDTO.getAddress())
                    .password(userDTO.getPassword())
                    .roleId(userDTO.getRoleId())
                    .isActive(false)
                    .facebookAccountId(userDTO.getFacebookAccountId())
                    .lastLoginAt(userDTO.getLastLoginAt())
                    .googleAccountId(userDTO.getGoogleAccountId())
                    .build();
            return userRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User updateUser(UserDTO userDTO, long id) throws Exception {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy id user để sửa"));
            roleRepository.findById(userDTO.getRoleId())
                    .orElseThrow(() -> new Exception("Mã roleid này không tồn tại"));
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setEmail(userDTO.getEmail());
            user.setAddress(userDTO.getAddress());
            user.setPassword(userDTO.getPassword());
            user.setRoleId(userDTO.getRoleId());
            user.setActive(false);
            user.setLastLoginAt(null);
            user.setFacebookAccountId(id);
            user.setGoogleAccountId(id);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteUser(long id) throws Exception {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không có id user này để xóa"));
            userRepository.delete(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
