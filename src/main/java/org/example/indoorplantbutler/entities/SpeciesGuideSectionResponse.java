package org.example.indoorplantbutler.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpeciesGuideSectionResponse(Integer id, String type, String description) {}
