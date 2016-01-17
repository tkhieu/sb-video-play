package me.kimhieu.snowballvideoplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimhieu on 1/18/16.
 */
public class AppData {

    public static AppData instance;
    public static List<String> videoList = new ArrayList<>();

    public AppData(){
        videoList.add("http://media.snowballnow.com/video/upload/v1451206914/lcgbutfkqbkhvrfdurrp.mp4");
        videoList.add("http://media.snowballnow.com/video/upload/v1450752299/deff3bxsmpsrow4i40e0.mp4");
        videoList.add("http://media.snowballnow.com/video/upload/v1450787135/poareeehaxfqhcyavnnl.mp4");
    }

    public static AppData getInstance(){
        if(instance == null) {
            instance = new AppData();
        }
        return instance;
    }
}
