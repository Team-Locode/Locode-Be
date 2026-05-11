package com.example.Locode.domain.bouquet.dto;

import java.util.List;

public record BouquetResponse(
        Long bouquetId,
        Summary summary
) {
    public record Summary(
            String purpose,
            String style,
            List<String> flowers,
            String paper,
            List<String> colorTone
    ) {}
}
