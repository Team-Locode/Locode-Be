package com.example.Locode.domain.detail.entity;

import com.example.Locode.domain.bouquet.entity.Bouquet;
import com.example.Locode.domain.flower.enums.FlowerColor;
import com.example.Locode.domain.flower.enums.FlowerType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bouquet_details")
@Getter
@NoArgsConstructor
public class BouquetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bouquet_id", nullable = false)
    private Bouquet bouquet;

    @Enumerated(EnumType.STRING)
    @Column(name = "flower_type", nullable = false)
    private FlowerType flowerType;

    @Enumerated(EnumType.STRING)
    @Column(name = "flower_color", nullable = false)
    private FlowerColor flowerColor;

    @Builder
    public BouquetDetail(Bouquet bouquet, FlowerType flowerType, FlowerColor flowerColor) {
        this.bouquet = bouquet;
        this.flowerType = flowerType;
        this.flowerColor = flowerColor;
    }
}
