package org.example.indoorplantbutler.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SpeciesImageResponse(String original_url) {}
