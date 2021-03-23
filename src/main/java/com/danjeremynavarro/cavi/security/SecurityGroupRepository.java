package com.danjeremynavarro.cavi.security;

import org.springframework.data.repository.CrudRepository;

public interface SecurityGroupRepository extends CrudRepository<SecurityGroup, Long> {
    SecurityGroup findByGroupName(String groupName);
}
