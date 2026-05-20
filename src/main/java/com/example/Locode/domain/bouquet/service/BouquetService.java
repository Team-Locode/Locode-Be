package com.example.Locode.domain.bouquet.service;

import com.example.Locode.domain.bouquet.dto.BouquetRequest;
import com.example.Locode.domain.bouquet.dto.BouquetResponse;
import com.example.Locode.domain.bouquet.entity.Bouquet;
import com.example.Locode.domain.bouquet.repository.BouquetRepository;
import com.example.Locode.domain.detail.entity.BouquetDetail;
import com.example.Locode.domain.detail.repository.BouquetDetailRepository;
import com.example.Locode.domain.flower.enums.FlowerColor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BouquetService {

    private final BouquetRepository bouquetRepository;
    private final BouquetDetailRepository bouquetDetailRepository;

    @Transactional
    public BouquetResponse create(String sessionId, BouquetRequest request) {
        Bouquet bouquet = bouquetRepository.save(
                Bouquet.builder()
                        .sessionId(sessionId)
                        .purpose(request.purpose())
                        .paperStyle(request.paperStyle())
                        .paperDesign(request.paperDesign())
                        .build()
        );

        List<BouquetDetail> details = request.flowers().stream()
                .map(f -> BouquetDetail.builder()
                        .bouquet(bouquet)
                        .flowerType(f.type())
                        .flowerColor(f.color())
                        .build())
                .toList();

        bouquetDetailRepository.saveAll(details);

        return toResponse(bouquet, details);
    }

    private BouquetResponse toResponse(Bouquet bouquet, List<BouquetDetail> details) {
        List<String> flowers = details.stream()
                .map(d -> d.getFlowerType().getKoreanName() + "(" + d.getFlowerColor().getKoreanName() + ")")
                .toList();

        List<FlowerColor> colors = details.stream()
                .map(BouquetDetail::getFlowerColor)
                .toList();

        return new BouquetResponse(
                bouquet.getId(),
                new BouquetResponse.Summary(
                        bouquet.getPurpose(),
                        bouquet.getPaperStyle().getKoreanName(),
                        flowers,
                        bouquet.getPaperDesign().getKoreanName(),
                        calculateColorTone(colors)
                )
        );
    }

    private List<String> calculateColorTone(List<FlowerColor> colors) {
        Map<FlowerColor, Long> freq = colors.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        long maxFreq = Collections.max(freq.values());

        if (colors.size() >= 3 && maxFreq == 1) return List.of("컬러풀");

        return freq.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq)
                .map(e -> e.getKey().getKoreanName())
                .toList();
    }
}
