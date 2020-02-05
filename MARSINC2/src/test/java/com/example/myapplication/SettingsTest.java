package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SettingsTest {
    private Settings mSettings;

    @Before
    public void setUp() throws Exception {
        mSettings = new Settings();
    }

    @Test
    public void testSum() throws Exception {

        assertEquals(0,mSettings.set(0));
        assertEquals(1,mSettings.set(1));
        assertEquals(2,mSettings.set(2));

    }


    @Test
    public void dark() throws Exception {
        assertEquals(1, mSettings.dark(1));
        assertEquals(0,mSettings.dark(0));
    }

    @Test
    public void port() throws Exception {
        assertEquals(1, mSettings.port(1));
        assertEquals(0,mSettings.port(0));
    }


}
