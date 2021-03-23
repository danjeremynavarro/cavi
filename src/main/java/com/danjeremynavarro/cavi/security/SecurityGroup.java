package com.danjeremynavarro.cavi.security;

import javax.persistence.*;
import java.util.Set;

/**
 * Security Group class for the cavi app
 * Users can be in multiple groups.
 * Most restrictive security group applies.
 */
@Entity
public class SecurityGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private Integer securityGroupId;

    @Column(nullable = false, unique = true)
    private String groupName;

    public SecurityGroup(String groupName) {
        this.groupName = groupName;
    }

    public SecurityGroup(){}

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    @ManyToMany(mappedBy = "groups")
    private Set<User> members;

    public Integer getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(Integer securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
