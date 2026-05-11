package com.example.Locode.domain.bouquet.repository;

import com.example.Locode.domain.bouquet.entity.Bouquet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetRepository extends JpaRepository<Bouquet, Long> {
}
