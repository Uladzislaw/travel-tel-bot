package com.uladzislau.travel_tel_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TravelTelegramBotApplication {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(TravelTelegramBotApplication.class, args);
    }
}
