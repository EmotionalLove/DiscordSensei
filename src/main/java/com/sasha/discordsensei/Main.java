package com.sasha.discordsensei;

import com.sasha.discordsensei.command.LoadedPacksCommand;
import com.sasha.discordsensei.teach.TeacherActivityContainer;
import com.sasha.simplecmdsys.SimpleCommandProcessor;
import com.sasha.simplesettings.SettingHandler;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.hooks.AnnotatedEventManager;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha at 12:36 PM on 12/21/2018
 */
public class Main {

    public static JDA discordInstance;
    public static Configuration config = new Configuration();
    public static SimpleCommandProcessor processor = new SimpleCommandProcessor(";");

    public static List<TeacherActivityContainer> loadedContainers = new ArrayList<>();

    public static void main(String[] args) throws LoginException, InstantiationException, IllegalAccessException {
        processor.register(LoadedPacksCommand.class);
        new SettingHandler("config.yml").read(config);
        discordInstance = new JDABuilder(config.discordToken).build();
        discordInstance.setEventManager(new AnnotatedEventManager());
        discordInstance.addEventListener(new MainDiscordEvents());
    }

}
