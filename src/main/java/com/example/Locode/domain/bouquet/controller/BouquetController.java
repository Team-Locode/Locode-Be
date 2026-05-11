package com.example.Locode.domain.bouquet.controller;

import com.example.Locode.domain.bouquet.dto.BouquetRequest;
import com.example.Locode.domain.bouquet.dto.BouquetResponse;
import com.example.Locode.domain.bouquet.service.BouquetService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bouquets")
@RequiredArgsConstructor
public class BouquetController {

    private final BouquetService bouquetService;

    @PostMapping
    public ResponseEntity<BouquetResponse> create(
            @RequestBody BouquetRequest request,
            HttpSession session) {
        return ResponseEntity.ok(bouquetService.create(session.getId(), request));
    }
}
