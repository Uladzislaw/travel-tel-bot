package com.uladzislau.travel_tel_bot.root.command.impl;

import com.uladzislau.travel_tel_bot.api.model.City;
import com.uladzislau.travel_tel_bot.api.rest.impl.CityRestService;
import com.uladzislau.travel_tel_bot.message.BotDictionary;
import com.uladzislau.travel_tel_bot.message.MessageSender;
import com.uladzislau.travel_tel_bot.root.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class AllCitiesCommand implements Command {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private CityRestService cityRestService;
    @Autowired
    private BotDictionary dictionary;

    @Override
    public SendMessage execute(Long chatId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cityRestService.getAllCities()) {
            stringBuilder.append(city.getName()).append("\n");
        }
        if (stringBuilder.toString().isEmpty()) {
            stringBuilder.append(dictionary.getNoCities());
        }
        return messageSender.sendMessage(chatId, stringBuilder.toString());
    }
}
