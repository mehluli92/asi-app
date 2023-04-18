package com.asi.app.service;

import com.asi.app.entity.Role;
import com.asi.app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role){
     return roleRepository.save(role);
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(int id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role getRoleByName(String title){
    return roleRepository.findByTitle(title);
    }

    public String deleteRole(int id){
    roleRepository.deleteById(id);
    return  "role deleted!"+id;
    }

    public Role updateRole(Role role){
        Role existingRole = roleRepository.findById(role.getId()).orElse(null);
        existingRole.setTitle(role.getTitle());
        existingRole.setDescription(role.getDescription());
        return roleRepository.save(existingRole);
    }
}
