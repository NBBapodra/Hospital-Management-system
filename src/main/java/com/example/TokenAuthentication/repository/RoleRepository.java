package com.example.TokenAuthentication.repository;

import java.util.Optional;

import com.example.TokenAuthentication.dto.exception.Enum.ERole;
import com.example.TokenAuthentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
