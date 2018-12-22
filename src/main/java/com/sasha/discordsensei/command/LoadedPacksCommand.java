package com.sasha.discordsensei.command;

import com.sasha.discordsensei.Main;
import com.sasha.discordsensei.MainDiscordEvents;
import com.sasha.discordsensei.teach.TeacherActivityContainer;
import com.sasha.simplecmdsys.SimpleCommand;

/**
 * Created by Sasha at 3:17 PM on 12/21/2018
 */
public class LoadedPacksCommand extends SimpleCommand {

    public LoadedPacksCommand() {
        super("list");
    }

    @Override
    public void onCommand() {
        StringBuilder builder = new StringBuilder("Packs:\n");
        for (TeacherActivityContainer loadedContainer : Main.loadedContainers) {
            builder.append(loadedContainer.getName() + "\n");
        }
        MainDiscordEvents.commandContextChannel.sendMessage(builder.toString()).submit();
    }
}
