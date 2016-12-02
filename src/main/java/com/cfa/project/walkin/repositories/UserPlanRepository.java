/**
 * 
 */
package com.cfa.project.walkin.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cfa.project.walkin.models.UserPlan;




/**
 * @author SANTOSH
 *
 */
@RepositoryRestResource

public interface UserPlanRepository extends JpaRepository<UserPlan,Long> {
	Page<UserPlan> findAll(Pageable pageable);
	UserPlan findByUser_username(@Param("username")String username);

}
