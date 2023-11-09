package com.thm.discord.client.listeners;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Slf4j
public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String message = event.getMessage().getContentDisplay();
        String user = event.getAuthor().getGlobalName();
        String userId = event.getAuthor().getId();
        log.info("Message from '{}'  id: {} body: {}", user, userId, message);

    }
}
