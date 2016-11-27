package com.cfa.project.walkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cfa.project.walkin.models.Role;



@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
