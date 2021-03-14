package com.danjeremynavarro.cavi.security;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * A simple login user.
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, unique = true)
	private Long userId;

	@Column(updatable = false, nullable = false)
	private Timestamp created;

	@Column(nullable = false)
	private Timestamp modified;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column
	private String firstName, middleName, lastName;
}
