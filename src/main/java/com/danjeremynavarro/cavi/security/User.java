package com.danjeremynavarro.cavi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple login user.
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false, unique = true)
	private Integer userId;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column
	private String firstName, middleName, lastName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="membership", joinColumns = @JoinColumn(name="userId"),
	inverseJoinColumns = @JoinColumn(name="securityGroupId"))
	private Set<SecurityGroup> groups;

	public Set<SecurityGroup> getGroups() {
		return groups;
	}

	public Collection<GrantedAuthority> getAuthorities(){
		class Authority implements GrantedAuthority{
			private String group;

			Authority(String g){
				this.group = g;
			}

			@Override
			public String getAuthority() {
				return group;
			}
		}

		HashSet<GrantedAuthority> gString = new HashSet<>();
		this.groups.forEach((SecurityGroup g)->{
			gString.add(new Authority(g.getGroupName()));
		});
		return gString;
	}

	public void setGroups(Set<SecurityGroup> groups) {
		this.groups = groups;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User(String username, String password,
				String firstName, String middleName, String lastName){
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.password = password;
	}

	public User() {
	}

	public String getFullName(){
		return (this.firstName + " " + this.middleName + " " + this.lastName);
	}
}
