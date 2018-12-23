package com.sasha.discordsensei.teach;

/**
 * Created by Sasha at 12:41 PM on 12/21/2018
 * <p>
 * The basic abstract class for various elements
 */
public abstract class TeacherActivity {

    private String activityName;

    public abstract void start(Student student);

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
