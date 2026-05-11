package com.example.Locode.domain.paper.controller;

import com.example.Locode.domain.paper.enums.PaperDesign;
import com.example.Locode.domain.paper.enums.PaperStyle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/papers")
public class PaperController implements PaperControllerDocs {

    @GetMapping("/styles")
    public ResponseEntity<List<Map<String, String>>> getStyles() {
        List<Map<String, String>> result = Arrays.stream(PaperStyle.values())
                .map(s -> Map.of("code", s.name(), "name", s.getKoreanName()))
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/designs")
    public ResponseEntity<List<Map<String, String>>> getDesigns(@RequestParam PaperStyle style) {
        List<Map<String, String>> result = PaperDesign.getByStyle(style).stream()
                .map(d -> Map.of("code", d.name(), "name", d.getKoreanName()))
                .toList();
        return ResponseEntity.ok(result);
    }
}
