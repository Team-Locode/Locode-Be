package com.example.Locode.domain.paper.controller;

import com.example.Locode.domain.paper.enums.PaperStyle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Tag(name = "포장지", description = "포장지 스타일 및 디자인 조회 API")
public interface PaperControllerDocs {

    @Operation(
            summary = "포장지 스타일 목록 조회",
            description = "선택 가능한 포장지 스타일 목록(CLASSIC, UNIQUE)을 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "조회 성공")
    ResponseEntity<List<Map<String, String>>> getStyles();

    @Operation(
            summary = "포장지 디자인 목록 조회",
            description = "선택한 스타일에 해당하는 포장지 디자인 목록을 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "조회 성공")
    ResponseEntity<List<Map<String, String>>> getDesigns(
            @Parameter(description = "포장지 스타일", example = "CLASSIC") PaperStyle style
    );
}
