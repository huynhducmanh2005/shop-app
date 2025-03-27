package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.RoleDTO;
import com.project.shopapp.Model.Role;

public interface IRoleService {
    void deleteRole(long id) throws Exception;

    List<Role> getAllRole();

    Role getByRoleId(long id) throws Exception;

    Role createRole(RoleDTO roleDTO) throws Exception;

    Role updateRole(RoleDTO roleDTO, long id) throws Exception;
}
