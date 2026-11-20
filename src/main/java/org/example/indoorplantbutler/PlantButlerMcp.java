package org.example.indoorplantbutler;

import org.example.indoorplantbutler.entities.SpeciesGuideResponse;
import org.example.indoorplantbutler.entities.SpeciesListResponse;
import org.example.indoorplantbutler.entities.Sunlight;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantButlerMcp {
    private final PlantApiClient plantApiClient;

    public PlantButlerMcp(PlantApiClient plantApiClient) {
        this.plantApiClient = plantApiClient;
    }

    @McpTool(description = "Get a list of all available indoor plants filtered by sunlight requirements.")
    public List<SpeciesListResponse> getPlants(Sunlight sunlight) {
        return plantApiClient.getPlants(sunlight.getValue());
    }


    @McpTool(description = "Get a care guide for watering, sunlight and pruning for a specific indoor plant.")
    public List<SpeciesGuideResponse> getCareGuide(int speciesId) {
        return plantApiClient.getCareGuide(speciesId);
    }
}
