package com.sasha.discordsensei.teach;

/**
 * Created by Sasha at 12:41 PM on 12/21/2018
 *
 * The basic abstract class for various elements
 */
public abstract class TeacherActivity {

    private String activityName;
    protected long channelId;
    protected long userId;

    public abstract void start();

    @Override
    public String toString() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }
}
