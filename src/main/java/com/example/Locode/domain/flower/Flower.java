package com.example.Locode.domain.flower;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flowers")
@Getter
@NoArgsConstructor
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "color_name", nullable = false)
    private String colorName;

    @Column(name = "color_hex", nullable = false)
    private String colorHex;
}
