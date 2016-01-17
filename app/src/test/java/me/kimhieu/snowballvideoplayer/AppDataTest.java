package me.kimhieu.snowballvideoplayer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by kimhieu on 1/18/16.
 */
public class AppDataTest {

    AppData appData;
    List<String> testList;


    @Before
    public void setUp() throws Exception {
        appData = AppData.getInstance();
        testList = appData.videoList;
    }

    @Test
    public void makeSureObjectHas3Items() throws Exception {
        assertEquals(testList.size(),3);
    }

    @Test
    public void makeSureVideoListIsArrayList() throws Exception {
        assertThat(testList, instanceOf(ArrayList.class));
    }
}
