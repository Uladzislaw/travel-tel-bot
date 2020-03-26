package com.uladzislau.travel_tel_bot.root.command.impl;

import com.uladzislau.travel_tel_bot.api.rest.RestService;
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
    private RestService restService;

    @Override
    public SendMessage execute(Long chatId) {

        return messageSender.sendMessage(chatId, restService.getAllCities().toString());
    }
}
