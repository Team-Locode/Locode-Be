package com.example.Locode.domain.detail;

import com.example.Locode.domain.bouquet.Bouquet;
import com.example.Locode.domain.flower.Flower;
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
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bouquet_id", nullable = false)
    private Bouquet bouquet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flower_id", nullable = false)
    private Flower flower;

    @Builder
    public BouquetDetail(Bouquet bouquet, Flower flower) {
        this.bouquet = bouquet;
        this.flower = flower;
    }
}
