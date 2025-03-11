package com.hplearn.preference_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long preferenceId;

    @Column(nullable = true)
    private String name;

    @ElementCollection
    @CollectionTable(name = "preference_tag", joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "tag_id")
    private List<Long> tags;
}
