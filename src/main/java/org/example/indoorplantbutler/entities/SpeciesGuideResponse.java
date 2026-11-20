package org.example.indoorplantbutler.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpeciesGuideResponse(
        Integer id,
        Integer species_id,
        String common_name,
        List<String> scientific_name,
        List<SpeciesGuideSectionResponse> section
) {}
