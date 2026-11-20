package org.example.indoorplantbutler.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlantApiResponse<T>(
        List<T> data,
        Integer to,
        Integer per_page,
        Integer current_page,
        Integer from,
        Integer last_page,
        Integer total
) {}
