package com.danjeremynavarro.cavi.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Credential {
    @Id
    @GeneratedValue
    @Column(updatable = false, unique = true)
    private Integer credentialId;
}
