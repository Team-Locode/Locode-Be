package com.example.Locode.domain.flower.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.Locode.domain.flower.enums.FlowerColor.*;

@Getter
@RequiredArgsConstructor
public enum FlowerType {
    ROSE       ("장미",       List.of(RED, BLUE, BLACK, WHITE)),
    GERBERA    ("게베라",     List.of(YELLOW, PINK, BLUE)),
    POMPON     ("폼폼국화",   List.of(YELLOW)),
    CARNATION  ("카네이션",   List.of(PINK)),
    TULIP  ("튤립",   List.of(RED, YELLOW)),
    LISIANTHUS ("리시안셔스", List.of(PINK)),
    LAVENDER   ("라벤더",     List.of(PURPLE));

    private final String koreanName;
    private final List<FlowerColor> availableColors;
}
