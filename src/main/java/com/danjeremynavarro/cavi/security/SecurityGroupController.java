package com.danjeremynavarro.cavi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityGroupController {

    private final SecurityGroupRepository securityGroupRepository;

    @Autowired
    SecurityGroupController(SecurityGroupRepository sr){
        securityGroupRepository = sr;
    }

    @GetMapping("/admin/security/group")
    public Iterable<SecurityGroup> getGroups(){
        return securityGroupRepository.findAll();
    }
}
