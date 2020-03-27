package com.uladzislau.travel_tel_bot.api.rest.impl;

import com.uladzislau.travel_tel_bot.api.UrlTemplate;
import com.uladzislau.travel_tel_bot.api.model.Content;
import com.uladzislau.travel_tel_bot.api.rest.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class ContentRestService implements RestService {

    private final RestTemplate restTemplate;

    public ContentRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Content getForCity(String cityName) {
        ResponseEntity<Content> response
                = restTemplate.getForEntity(format(UrlTemplate.GET_CONTENT_FOR_CITY, cityName), Content.class);
        return Optional.ofNullable(response.getBody())
                .orElse(new Content());
    }
}
