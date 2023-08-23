package com.capstone.rideitout.repositories;

import com.capstone.rideitout.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
        Users findByUsername(String username);

}
