package com.danjeremynavarro.cavi.security;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Long securityGroupId;

    @Column(updatable = false, nullable = false)
    private Timestamp created;

    @Column(nullable = false, unique = true)
    private String groupName;
}
