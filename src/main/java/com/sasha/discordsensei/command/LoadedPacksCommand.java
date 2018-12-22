package com.sasha.discordsensei.command;

import com.sasha.discordsensei.Main;
import com.sasha.discordsensei.MainDiscordEvents;
import com.sasha.discordsensei.teach.TeacherActivityContainer;
import com.sasha.simplecmdsys.SimpleCommand;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

/**
 * Created by Sasha at 3:17 PM on 12/21/2018
 */
public class LoadedPacksCommand extends SimpleCommand {

    public LoadedPacksCommand() {
        super("packs");
    }

    @Override
    public void onCommand() {
        EmbedBuilder e = new EmbedBuilder();
        e.setTitle("Loaded teacher packs:");
        e.setThumbnail("https://cdn.discordapp.com/attachments/525511674375962635/525526603023777793/photo.jpg"); // cute boy
        StringBuilder builder = new StringBuilder();
        for (TeacherActivityContainer loadedContainer : Main.loadedContainers) {
            builder.append(loadedContainer.getName()).append(" (").append(loadedContainer.getAuthor()).append(")").append("\n");
        }
        e.setDescription(builder.toString());
        e.setColor(Color.pink);
        MainDiscordEvents.commandContextChannel.sendMessage(e.build()).submit();
    }
}
