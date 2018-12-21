package com.sasha.discordsensei;

import com.sasha.simplesettings.SettingHandler;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.AnnotatedEventManager;

import javax.security.auth.login.LoginException;

/**
 * Created by Sasha at 12:36 PM on 12/21/2018
 */
public class Main {

    public static JDA discordInstance;
    public static Configuration config = new Configuration();

    public static void main(String[] args) throws LoginException {
        new SettingHandler("config.yml").read(config);
        discordInstance = new JDABuilder(config.discordToken).build();
        discordInstance.setEventManager(new AnnotatedEventManager());
    }

}
