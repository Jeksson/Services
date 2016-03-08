package com.jekss.service.serv;

import com.jekss.entityes.Role;
import com.jekss.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jekss on 11.10.15.
 */
@Service
public class RoleServ {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role){
        Role role1 = roleRepository.saveAndFlush(role);
        return role1;
    }

    public Role getByName(String role){
        Role role1 = roleRepository.findByName(role);
        return role1;
    }
    public Role getByIdRole(int id){
        Role role = roleRepository.findOne(id);
        return role;
    }
    public  Role editRole(Role role){
        return roleRepository.saveAndFlush(role);
    }
    public void deleteRole(int id){
        roleRepository.delete(id);
    }
}
