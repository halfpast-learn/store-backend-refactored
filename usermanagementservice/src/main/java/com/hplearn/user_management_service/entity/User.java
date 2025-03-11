package com.hplearn.user_management_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @ElementCollection
    @CollectionTable(name = "preference_user", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "preference_id")
    private Set<Long> preferenceIds;

    @ElementCollection
    @CollectionTable(name = "user_orders", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "order_id")
    private Set<Long> orderIds;
}
