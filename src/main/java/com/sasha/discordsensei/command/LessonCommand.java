package com.sasha.discordsensei.command;

import com.sasha.discordsensei.Main;
import com.sasha.discordsensei.MainDiscordEvents;
import com.sasha.discordsensei.teach.Student;
import com.sasha.discordsensei.teach.TeacherActivityContainer;
import com.sasha.discordsensei.teach.impl.LessonActivity;
import com.sasha.simplecmdsys.SimpleCommand;

/**
 * Created by Sasha at 6:36 PM on 12/21/2018
 */
public class LessonCommand extends SimpleCommand {

    public LessonCommand() {
        super("lesson");
    }

    @Override
    public void onCommand() {
        if (this.getArguments() == null || this.getArguments().length != 1) {
            MainDiscordEvents.commandContextChannel.sendMessage("Unexpected args. Please specify the name of the lesson you want to start.").submit();
            return;
        }
        for (TeacherActivityContainer loadedContainer : Main.loadedContainers) {
            LessonActivity lessonActivity = loadedContainer.getLessonByName(this.getArguments()[0]);
            if (lessonActivity != null) {
                lessonActivity.start(new Student(MainDiscordEvents.commandContextUser, MainDiscordEvents.commandContextChannel, lessonActivity));
                return;
            }
        }
        MainDiscordEvents.commandContextChannel.sendMessage("That lesson doesn't exist. Maybe check your spelling?").submit();
    }
}
