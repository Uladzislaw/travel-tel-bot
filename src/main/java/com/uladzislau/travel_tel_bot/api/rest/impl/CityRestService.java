package com.uladzislau.travel_tel_bot.api.rest.impl;

import com.uladzislau.travel_tel_bot.api.UrlTemplate;
import com.uladzislau.travel_tel_bot.api.model.City;
import com.uladzislau.travel_tel_bot.api.rest.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CityRestService implements RestService {

    private final RestTemplate restTemplate;

    public CityRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<City> getAllCities() {
        ResponseEntity<City[]> response =
                restTemplate.getForEntity(UrlTemplate.GET_ALL_CITIES, City[].class);
        return List.of(
                Optional.ofNullable(response.getBody())
                .orElse(new City[0]));
    }
}
