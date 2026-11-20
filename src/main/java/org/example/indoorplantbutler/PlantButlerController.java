package org.example.indoorplantbutler;

import org.example.indoorplantbutler.entities.SpeciesListResponse;
import org.example.indoorplantbutler.entities.Sunlight;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlantButlerController {

    private final PlantApiClient plantApiClient;

    public PlantButlerController(PlantApiClient plantApiClient) {
        this.plantApiClient = plantApiClient;
    }

    @GetMapping("/plants")
    public ResponseEntity<List<SpeciesListResponse>> getPlants() {
        return ResponseEntity.ok(plantApiClient.getPlants(Sunlight.FULL_SHADE.getValue()));
    }
}
