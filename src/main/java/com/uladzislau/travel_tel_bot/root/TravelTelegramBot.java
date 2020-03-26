package com.uladzislau.travel_tel_bot.root;

import com.uladzislau.travel_tel_bot.message.BotDictionary;
import com.uladzislau.travel_tel_bot.message.MessageSender;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource(value = "classpath:telegram.properties", encoding = "UTF-8")
public class TravelTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Autowired
    private BotDictionary dictionary;
    @Autowired
    private MessageSender messageSender;

    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        Long chatId = update.getMessage().getChatId();
        final String message = update.getMessage().getText();
        if (message.equals("/start")) {
            execute(messageSender.sendMessage(chatId, dictionary.getStartMsg()));
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}
