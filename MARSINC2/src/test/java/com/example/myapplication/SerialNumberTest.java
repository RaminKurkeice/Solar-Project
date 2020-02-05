package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class SerialNumberTest {

    private SerialNumber mSerial;


    private String min="123456789";
    private String max = "987654321";
    @Before
    public void setUp() throws Exception {
        mSerial = new SerialNumber();
    }

    @Test
    public void testSum() throws Exception {

        assertEquals(true,mSerial.serial("123456789"));

    }

    @Test
    public void testS() throws Exception{

        assertNotEquals(true,mSerial.serial("997654321"));
    }
    @Test
    public void tes() throws Exception {

        assertEquals(0,mSerial.set(0));
        assertEquals(1,mSerial.set(1));
        assertEquals(2,mSerial.set(2));

    }


    @Test
    public void dark() throws Exception {
        assertEquals(1, mSerial.dark(1));
        assertEquals(0,mSerial.dark(0));
    }

    @Test
    public void port() throws Exception {
        assertEquals(1, mSerial.port(1));
        assertEquals(0,mSerial.port(0));
    }

}

