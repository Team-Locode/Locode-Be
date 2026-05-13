package com.example.Locode.domain.flower.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerColor {
    RED("빨강"),
    BLUE("파랑"),
    YELLOW("노랑"),
    PINK("분홍"),
    PURPLE("보라"),
    BLACK("검정"),
    WHITE("하양");

    private final String koreanName;
}
