package com.uladzislau.travel_tel_bot.message;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:telegram.properties", encoding = "UTF-8")
@Data
public class BotDictionary {

    @Value("${msg.start}")
    private String startMsg;

    @Value("${msg.unknown_city}")
    private String unknownCity;

    @Value("${msg.unknown_command}")
    private String unknownCommand;

    @Value("${msg.cities.empty}")
    private String noCities;
}
