package com.thm.discord.client;

import com.thm.discord.client.listeners.MessageListener;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscordBotClient extends ListenerAdapter {

    private DiscordBotClient() {
        String token = "XXX";

        try {
            JDA jda = JDABuilder.createDefault(token)
                    .addEventListeners(this)
//                    .setActivity(Activity.playing("MEM ● りった"))
                    .setActivity(Activity.listening("memory"))
                    .setStatus(OnlineStatus.ONLINE)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .build();
            log.info("Starting listener ...");
            jda.awaitReady();
            jda.addEventListener(createNewTextMessageListener());
        } catch (InterruptedException e) {
            log.error("Unable to login; error: {}", e.getMessage());
        }
    }

    private MessageListener createNewTextMessageListener() {
        return new MessageListener();
    }

    @Override
    public void onReady(ReadyEvent event) {
        log.info("Zalogowano do serwera Discord jako: " + event.getJDA().getSelfUser().getName());
    }

    public void doSomething() {
        log.info("Do something");
    }
}