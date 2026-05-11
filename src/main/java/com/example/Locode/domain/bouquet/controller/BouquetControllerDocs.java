package com.example.Locode.domain.bouquet.controller;

import com.example.Locode.domain.bouquet.dto.BouquetRequest;
import com.example.Locode.domain.bouquet.dto.BouquetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

@Tag(name = "꽃다발", description = "꽃다발 생성 및 주문 요약 API")
public interface BouquetControllerDocs {

    @Operation(
            summary = "꽃다발 생성",
            description = "선물 목적, 꽃 목록(최대 5개), 포장지 스타일·디자인을 입력받아 꽃다발을 저장하고 주문 요약을 반환합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = "생성 성공",
            content = @Content(schema = @Schema(implementation = BouquetResponse.class))
    )
    ResponseEntity<BouquetResponse> create(BouquetRequest request, HttpSession session);
}
