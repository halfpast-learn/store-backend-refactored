package com.hplearn.user_management_service.repository;

import com.hplearn.user_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.orderIds WHERE u.userId = :userId")
    Optional<User> findUserWithOrders(Long userId);
}
