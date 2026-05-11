package com.example.Locode.domain.flower.controller;

import com.example.Locode.domain.flower.enums.FlowerType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController implements FlowerControllerDocs {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getFlowers() {
        List<Map<String, Object>> result = Arrays.stream(FlowerType.values())
                .map(f -> Map.<String, Object>of(
                        "type", f.name(),
                        "name", f.getKoreanName(),
                        "colors", f.getAvailableColors().stream()
                                .map(c -> Map.of("code", c.name(), "name", c.getKoreanName()))
                                .toList()
                ))
                .toList();
        return ResponseEntity.ok(result);
    }
}
