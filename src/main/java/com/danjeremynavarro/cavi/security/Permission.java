package com.danjeremynavarro.cavi.security;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Allowable permission of a given group to a registered document
 */
@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, unique = true)
	private Long identifier;

	@Column(updatable = false, nullable = false)
	private Timestamp created;

	@Column(nullable = false)
	private Timestamp modified;

	@ManyToOne
	@JoinColumn(nullable = false)
	private SecurityGroup securityGroup;

	@ManyToOne
	@JoinColumn(nullable = false)
	private RegisteredDocument registeredDocument;

	@Column(nullable = false)
	private Boolean read;

	@Column(nullable = false)
	private Boolean create;

	@Column(nullable = false)
	private Boolean delete;

	@Column(nullable = false)
	private Boolean update;
}
