package org.example.indoorplantbutler.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sunlight {
    FULL_SHADE("full_shade"),
    PART_SHADE("part_shade"),
    SUN_PART_SHADE("sun-part_shade"),
    FULL_SUN("full_sun");

    private final String value;
}
