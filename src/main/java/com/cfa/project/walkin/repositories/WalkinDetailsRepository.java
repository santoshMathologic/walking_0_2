package com.cfa.project.walkin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cfa.project.walkin.models.WalkingDetails;

@RepositoryRestResource
public interface WalkinDetailsRepository extends JpaRepository<WalkingDetails, Long>{

}
