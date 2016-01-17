package me.kimhieu.snowballvideoplayer;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kimhieu on 1/18/16.
 */
public class AppDataTest {

    @Test
    public void makeSureObjectHas3Items() throws Exception {
        AppData appData = AppData.getInstance();
        List<String> testList = appData.videoList;
        assertEquals(testList.size(),3);
    }
}
