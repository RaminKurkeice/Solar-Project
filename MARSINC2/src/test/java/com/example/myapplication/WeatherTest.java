package com.example.myapplication;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WeatherTest {

    private Weather weather;

    @Before
    public void setUp() throws Exception {
        weather = new Weather();
    }

    @Test
    public void testweather() throws Exception {
        //expected: 6, sum of 1 and 5
        assertEquals(1, weather.getTemp(1));

    }
@Test
    public void testLocation() throws Exception {
        assertEquals(true, weather.TestLocationChange());
    }
    @Test
    public void testOnResume() throws Exception {
        assertEquals(true, weather.testOnresume());
    }

    @Test
    public void testEnable() throws Exception {
        assertEquals(true, weather.TestonProviderEnabled("Enabled new provider"));
    }
    @Test
    public void testDisabled() throws Exception {
        assertEquals(true, weather.TestonProviderDisabled("Disabled provider"));
    }
    @Test
    public void testStatus() throws Exception {
        assertEquals(true, weather.TestStatus("null"));
    }
}
