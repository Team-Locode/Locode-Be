package com.example.Locode.domain.flower.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Tag(name = "꽃", description = "꽃 목록 조회 API")
public interface FlowerControllerDocs {

    @Operation(
            summary = "꽃 목록 조회",
            description = "선택 가능한 꽃 종류와 각 꽃별 색상 목록을 반환합니다. DB 조회 없이 Enum 기반으로 응답합니다."
    )
    @ApiResponse(responseCode = "200", description = "조회 성공")
    ResponseEntity<List<Map<String, Object>>> getFlowers();
}
