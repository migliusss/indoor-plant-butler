package org.example.indoorplantbutler;

import org.example.indoorplantbutler.entities.PlantApiResponse;
import org.example.indoorplantbutler.entities.SpeciesGuideResponse;
import org.example.indoorplantbutler.entities.SpeciesListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlantApiClient {

    private final RestClient restClient;

    @Value("${plant.api.key}")
    private String apiKey;

    public PlantApiClient(@Value("${plant.api.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl("https://perenual.com/api/v2")
                .build();
        this.apiKey = apiKey;
    }

    public List<SpeciesListResponse> getPlants(String sunlight) {
        List<SpeciesListResponse> all = new ArrayList<>();
        int page = 1;
        int lastPage = 1;

        try {
            do {
                final int currentPage = page;

                PlantApiResponse<SpeciesListResponse> response = restClient.get()
                        .uri(uri -> uri
                                .path("/species-list")
                                .queryParam("key", apiKey)
                                .queryParam("page", currentPage)
                                .queryParam("indoor", 1)
                                .queryParamIfPresent("sunlight", Optional.ofNullable(sunlight))
                                .build())
                        .retrieve()
                        .body(new ParameterizedTypeReference<>() {
                        });

                if (response == null || response.data() == null || response.data().isEmpty()) break;

                all.addAll(response.data());

                if (response.last_page() != null) {
                    lastPage = response.last_page();
                }

                page++;
            } while (page <= lastPage);
        } catch (Exception e) {
            throw new RuntimeException("error fetching plants: " + e.getMessage());
        }

        return all;
    }

    public List<SpeciesGuideResponse> getCareGuide(int speciesId) {
        try {
            PlantApiResponse<SpeciesGuideResponse> response = restClient.get()
                    .uri(uri -> uri
                            .path("/species-care-guide-list")
                            .queryParam("key", apiKey)
                            .queryParam("species_id", speciesId)
                            .build())
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return response == null || response.data() == null
                    ? List.of()
                    : response.data();
        } catch (Exception e) {
            throw new RuntimeException("error fetching care guide for species: " + e.getMessage());
        }
    }
}
