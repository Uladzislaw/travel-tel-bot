package com.uladzislau.travel_tel_bot.message;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class MessageSender {
    public SendMessage sendMessage(Long chatId, String msg) {
        return new SendMessage()
                .setChatId(chatId)
                .setText(msg);
    }
}
