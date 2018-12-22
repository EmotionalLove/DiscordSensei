package com.sasha.discordsensei.teach.impl;

import com.sasha.discordsensei.Main;
import com.sasha.discordsensei.teach.Student;
import com.sasha.discordsensei.teach.TeacherActivity;
import net.dv8tion.jda.core.EmbedBuilder;

import java.util.ArrayList;

/**
 * Created by Sasha at 1:29 PM on 12/21/2018
 */
public class LessonActivity extends TeacherActivity {

    public String objective;
    public ArrayList<String> sections = new ArrayList<>();
    public String gotoNxt;

    @Override
    public void start(Student student) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle(this.getActivityName());
        StringBuilder builder1 = new StringBuilder();
        for (String section : sections) {
            builder1.append("\n\n").append(section);
        }
        builder.setDescription("**Objective** > " + objective + builder1.toString() + ((gotoNxt != null) ? "**Also try** > " + gotoNxt : ""));
        student.getChannel(Main.discordInstance).sendMessage(builder.build()).submit();
    }
}
