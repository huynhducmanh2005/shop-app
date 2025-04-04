package com.project.shopapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
