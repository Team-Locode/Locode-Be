package com.example.Locode.domain.flower.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerColor {
    RED("레드"),
    BLUE("블루"),
    YELLOW("옐로우"),
    PINK("핑크"),
    PURPLE("퍼플"),
    BLACK("블랙"),
    WHITE("화이트");

    private final String koreanName;
}
