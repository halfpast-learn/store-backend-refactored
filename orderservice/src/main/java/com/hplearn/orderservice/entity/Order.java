package com.hplearn.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = true)
    private String status;

    @Column(nullable = true)
    private String comment;

    @Column(name = "user_owner_id")
    private Long userOwnerId;

    @ElementCollection
    @CollectionTable(name = "order_item_ids", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "item_id")
    private List<Long> itemIds;
}
