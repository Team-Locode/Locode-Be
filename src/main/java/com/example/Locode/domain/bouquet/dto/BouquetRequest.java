package com.example.Locode.domain.bouquet.dto;

import com.example.Locode.domain.flower.enums.FlowerColor;
import com.example.Locode.domain.flower.enums.FlowerType;
import com.example.Locode.domain.paper.enums.PaperDesign;
import com.example.Locode.domain.paper.enums.PaperStyle;

import java.util.List;

public record BouquetRequest(
        String purpose,
        List<FlowerEntry> flowers,
        PaperStyle paperStyle,
        PaperDesign paperDesign
) {
    public record FlowerEntry(
            FlowerType type,
            FlowerColor color
    ) {}
}
