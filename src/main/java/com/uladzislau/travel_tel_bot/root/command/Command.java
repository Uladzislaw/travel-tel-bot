package com.uladzislau.travel_tel_bot.root.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Command {
    SendMessage execute(Long chatId);
}
