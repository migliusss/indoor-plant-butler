package org.example.indoorplantbutler.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpeciesListResponse(
        Integer id,
        String common_name,
        List<String> scientific_name,
        String family,
        SpeciesImageResponse default_image
) {}
