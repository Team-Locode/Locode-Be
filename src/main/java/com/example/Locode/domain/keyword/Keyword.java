package com.example.Locode.domain.keyword;

import com.example.Locode.domain.bouquet.Bouquet;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "keywords")
@Getter
@NoArgsConstructor
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bouquet_id", nullable = false)
    private Bouquet bouquet;

    @Column(nullable = false)
    private String keyword;

    @Builder
    public Keyword(Bouquet bouquet, String keyword) {
        this.bouquet = bouquet;
        this.keyword = keyword;
    }
}
