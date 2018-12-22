package com.sasha.discordsensei;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

/**
 * Created by Sasha at 3:19 PM on 12/21/2018
 */
public class MainDiscordEvents {

    public static TextChannel commandContextChannel;
    public static User commandContextUser;

    @SubscribeEvent
    public void onMsgRx(GuildMessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;
        if (e.getMessage().getContentDisplay().startsWith(";")) {
            commandContextChannel = e.getChannel();
            commandContextUser = e.getAuthor();
            Main.processor.processCommand(e.getMessage().getContentDisplay());
        }
    }
}
