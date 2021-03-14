package com.danjeremynavarro.cavi.security;

import javax.persistence.*;

/**
 * Membership associations of a user to a group
 */
@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long membershipId;

    @OneToOne
    private User user;

    @OneToOne
    private SecurityGroup securityGroup;
}
