package com.example.Locode.domain.bouquet.entity;

import com.example.Locode.domain.detail.entity.BouquetDetail;
import com.example.Locode.domain.paper.enums.PaperDesign;
import com.example.Locode.domain.paper.enums.PaperStyle;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bouquets")
@Getter
@NoArgsConstructor
public class Bouquet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(nullable = false)
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "paper_style", nullable = false)
    private PaperStyle paperStyle;

    @Enumerated(EnumType.STRING)
    @Column(name = "paper_design", nullable = false)
    private PaperDesign paperDesign;

    @OneToMany(mappedBy = "bouquet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BouquetDetail> details = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public Bouquet(String sessionId, String purpose, PaperStyle paperStyle, PaperDesign paperDesign) {
        this.sessionId = sessionId;
        this.purpose = purpose;
        this.paperStyle = paperStyle;
        this.paperDesign = paperDesign;
    }
}
