package com.example.Locode.domain.paper.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaperStyle {
    CLASSIC("클래식"),
    UNIQUE("유니크");

    private final String koreanName;
}
