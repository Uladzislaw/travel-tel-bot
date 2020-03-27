package com.uladzislau.travel_tel_bot.root;

import com.uladzislau.travel_tel_bot.api.model.Content;
import com.uladzislau.travel_tel_bot.api.rest.impl.ContentRestService;
import com.uladzislau.travel_tel_bot.message.BotDictionary;
import com.uladzislau.travel_tel_bot.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class UserMessageProcessor {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private ContentRestService contentRestService;
    @Autowired
    private BotDictionary dictionary;

    public SendMessage sendResponse(Long chatId, String userMessage) {
        Content content = contentRestService.getForCity(userMessage);
        if (content.getText().isEmpty() || content.getText().isBlank()) {
            return messageSender.sendMessage(chatId, dictionary.getUnknownCity());
        }
        return messageSender.sendMessage(chatId, content.getText());
    }
}
