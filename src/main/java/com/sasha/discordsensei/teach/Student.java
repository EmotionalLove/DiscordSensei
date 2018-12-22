package com.sasha.discordsensei.teach;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by Sasha at 1:33 PM on 12/21/2018
 */
public class Student {

    private long userId;
    private long channelId;
    private TeacherActivity currentActivity;

    public Student(User user, TextChannel channel, TeacherActivity activity) {
        this.userId = user.getIdLong();
        this.channelId = channel.getIdLong();
        this.currentActivity = activity;
    }

    public User getUser(JDA discord) {
        return discord.getUserById(userId);
    }

    public Member getMember(JDA discord) {
        return this.getChannel(discord).getGuild().getMember(this.getUser(discord));
    }

    public TextChannel getChannel(JDA discord) {
        return discord.getTextChannelById(channelId);
    }

    public TeacherActivity getCurrentActivity() {
        return currentActivity;
    }
}
