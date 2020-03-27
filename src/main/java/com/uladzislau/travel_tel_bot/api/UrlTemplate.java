package com.uladzislau.travel_tel_bot.api;

public class UrlTemplate {

    private static final String DEFAULT_DOMAIN_NAME_PROTOCOL = "http://localhost:8080/";
    private static final String API_V1 = "api/v1/";

    private static final String CITY = "city/";
    private static final String CONTENT = "content/";

    public final static String GET_ALL_CITIES = DEFAULT_DOMAIN_NAME_PROTOCOL + API_V1 + CITY + "all";
    public static final String GET_CONTENT_FOR_CITY = DEFAULT_DOMAIN_NAME_PROTOCOL + API_V1 + CONTENT + "one/%s";
}
