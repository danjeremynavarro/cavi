package com.danjeremynavarro.cavi.security;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * A document is a database table and must be unique.
 */
@Entity
public class RegisteredDocument {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, nullable = false,unique = true)
    private Long documentId;

    @Column(updatable = false, nullable = false, unique = true)
    private String documentName;

    @Column(updatable = false, nullable = false)
    private Timestamp created;

    @Column(nullable = false)
    private Timestamp modified;
}
