package com.fatidev.FatiHotel.repo;

import com.fatidev.FatiHotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
