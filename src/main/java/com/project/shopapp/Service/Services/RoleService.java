package com.project.shopapp.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.RoleDTO;
import com.project.shopapp.Model.Role;
import com.project.shopapp.Repository.RoleRepository;
import com.project.shopapp.Service.Impl.IRoleService;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void deleteRole(long id) throws Exception {
        try {
            Role role = roleRepository.findById(id)
                    .orElseThrow(() -> new Exception("không tìm thấy id role này để xóa"));
            roleRepository.delete(role);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Role getByRoleId(long id) throws Exception {
        try {
            return roleRepository.findById(id).orElseThrow(() -> new Exception("không tìm thấy id role này"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Role createRole(RoleDTO roleDTO) throws Exception {
        try {
            Role role = Role.builder()
                    .name(roleDTO.getName())
                    .build();
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Role updateRole(RoleDTO roleDTO, long id) throws Exception {
        try {
            Role role = roleRepository.findById(id)
                    .orElseThrow(() -> new Exception("không tìm thấy id role này để sửa"));
            role.setName(roleDTO.getName());
            return roleRepository.save(role);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

}
