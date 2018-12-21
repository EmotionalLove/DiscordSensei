package com.sasha.discordsensei;

import com.sasha.simplesettings.annotation.Setting;

import java.util.ArrayList;

/**
 * Created by Sasha at 12:37 PM on 12/21/2018
 *
 * Class that holds the config.yml configuration values
 */
public class Configuration {

    @Setting public String discordToken = null;
    @Setting public ArrayList<String> adminIds = new ArrayList<>();
    {
        adminIds.add("483665844866514944");
    }
    @Setting public String teachingpacksDir = "teachingpacks";

}
