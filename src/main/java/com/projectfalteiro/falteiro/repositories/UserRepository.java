package com.projectfalteiro.falteiro.repositories;

import com.projectfalteiro.falteiro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
