package com.thm.discord.controller;

import com.thm.discord.client.DiscordBotClient;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DiscordBotController {
    private final DiscordBotClient discordBotClient;

    @PostConstruct
    public void init() {
        discordBotClient.doSomething();
    }

}