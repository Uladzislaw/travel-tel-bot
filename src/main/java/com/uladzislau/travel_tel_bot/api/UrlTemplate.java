package com.uladzislau.travel_tel_bot.api;

public class UrlTemplate {

    private static final String DEFAULT_DOMAIN_NAME_PROTOCOL = "http://localhost:8080/";
    private static final String API_V1 = "api/v1/";

    private static final String CITY = "city/";

    public final static String GET_ALL_CITIES = DEFAULT_DOMAIN_NAME_PROTOCOL + API_V1 + CITY + "all";
}
