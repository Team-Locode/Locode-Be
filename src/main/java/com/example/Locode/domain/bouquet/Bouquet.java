package com.example.Locode.domain.bouquet;

import com.example.Locode.domain.detail.BouquetDetail;
import com.example.Locode.domain.keyword.Keyword;
import com.example.Locode.domain.paper.Paper;
import com.example.Locode.domain.purpose.Purpose;
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
    private Integer id;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_id", nullable = false)
    private Paper paper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purposes_id", nullable = false)
    private Purpose purpose;

    @OneToMany(mappedBy = "bouquet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BouquetDetail> details = new ArrayList<>();

    @OneToMany(mappedBy = "bouquet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Keyword> keywords = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public Bouquet(String sessionId, Paper paper, Purpose purpose) {
        this.sessionId = sessionId;
        this.paper = paper;
        this.purpose = purpose;
    }
}
