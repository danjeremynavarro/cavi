package com.danjeremynavarro.cavi;

import com.danjeremynavarro.cavi.security.SecurityGroup;
import com.danjeremynavarro.cavi.security.SecurityGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.danjeremynavarro.cavi.security.UserRepository;
import com.danjeremynavarro.cavi.security.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class CaviCommandLineRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(CaviCommandLineRunner.class);

    final UserRepository userRepository;

    final SecurityGroupRepository securityGroupRepository;

    @Autowired
    public CaviCommandLineRunner(UserRepository userRepository, SecurityGroupRepository securityGroupRepository) {
        this.userRepository = userRepository;
        this.securityGroupRepository = securityGroupRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SecurityGroup s1 = new SecurityGroup("ADMIN");
        SecurityGroup s2 = new SecurityGroup("USER");
        ArrayList<SecurityGroup> collection = new ArrayList<>();
        collection.add(s1);
        collection.add(s2);
        securityGroupRepository.saveAll(collection);
        User user1 = new User("admin", "$2y$12$b.EVp7W4Tm0LMxnfoQuM7OnSwQ5pXY3Xs23JN5sHlzy88HvSmXD2q", "Admin", "mn", "ln");
        HashSet<SecurityGroup> groups = new HashSet<>();
        groups.add(s1);
        groups.add(s2);
        user1.setGroups(groups);
        userRepository.save(user1);
        User u = userRepository.findByUsername("admin");
    }
}
