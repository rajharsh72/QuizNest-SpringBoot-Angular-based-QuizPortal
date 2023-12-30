package com.quiznestserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiznestserver.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
