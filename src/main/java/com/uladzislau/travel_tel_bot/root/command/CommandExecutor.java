package com.uladzislau.travel_tel_bot.root.command;

import com.uladzislau.travel_tel_bot.root.command.impl.AllCitiesCommand;
import com.uladzislau.travel_tel_bot.root.command.impl.StartCommand;
import com.uladzislau.travel_tel_bot.root.command.impl.UnknownCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class CommandExecutor {

    private Map<String, Command> commands;

    @Autowired
    private StartCommand startCommand;
    @Autowired
    private AllCitiesCommand allCitiesCommand;
    @Autowired
    private UnknownCommand unknownCommand;

    @PostConstruct
    private void init() {
        commands = Map.of(
                BotCommand.UNKNOWN, unknownCommand,
                BotCommand.START, startCommand,
                BotCommand.CITIES, allCitiesCommand);
    }

    public SendMessage execute(String command, Long chatId) {
        if (!commands.containsKey(command)) {
            return commands.get(BotCommand.UNKNOWN).execute(chatId);
        }
        return commands.get(command).execute(chatId);
    }
}
