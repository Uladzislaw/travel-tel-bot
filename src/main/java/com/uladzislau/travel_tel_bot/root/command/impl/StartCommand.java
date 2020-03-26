package com.uladzislau.travel_tel_bot.root.command.impl;

import com.uladzislau.travel_tel_bot.message.BotDictionary;
import com.uladzislau.travel_tel_bot.message.MessageSender;
import com.uladzislau.travel_tel_bot.root.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class StartCommand implements Command {

    @Autowired
    private BotDictionary dictionary;
    @Autowired
    private MessageSender messageSender;

    @Override
    public SendMessage execute(Long chatId) {
        return messageSender.sendMessage(chatId, dictionary.getStartMsg());
    }
}
