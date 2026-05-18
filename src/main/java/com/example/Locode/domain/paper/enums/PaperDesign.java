package com.example.Locode.domain.paper.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.example.Locode.domain.paper.enums.PaperStyle.*;

@Getter
@RequiredArgsConstructor
public enum PaperDesign {
    // , 베이지(갈색), , , , ,
    CLASSIC_PINK         (CLASSIC, "분홍"),
    CLASSIC_YELLOW       (CLASSIC, "노랑"),
    CLASSIC_WHITE        (CLASSIC, "하양"),
    CLASSIC_PURPLE       (CLASSIC, "보라"),
    CLASSIC_GREEN        (CLASSIC, "초록"),
    CLASSIC_SKY_BLUE     (CLASSIC, "하늘"),
    CLASSIC_BEIGE     (CLASSIC, "베이지"),
    UNIQUE_ORIENTAL      (UNIQUE,  "오리엔탈"),
    UNIQUE_FRENCH_VINTAGE(UNIQUE,  "프렌치빈티지"),
    UNIQUE_WHITE         (UNIQUE,  "하양"),
    UNIQUE_BLACK         (UNIQUE,  "검정");

    private final PaperStyle style;
    private final String koreanName;

    public static List<PaperDesign> getByStyle(PaperStyle style) {
        return Arrays.stream(values())
                .filter(d -> d.style == style)
                .toList();
    }
}
