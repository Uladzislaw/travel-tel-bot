package com.uladzislau.travel_tel_bot.api.rest;

import com.uladzislau.travel_tel_bot.api.UrlTemplate;
import com.uladzislau.travel_tel_bot.api.model.City;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<City> getAllCities() {
        ResponseEntity<City[]> response =
                this.restTemplate.getForEntity(UrlTemplate.GET_ALL_CITIES, City[].class);
        return List.of(Objects.requireNonNull(response.getBody()));
    }
}
