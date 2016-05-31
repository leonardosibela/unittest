package com.sibela.examples.temperatureconverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterUtilTest {

    @Test
    public void testConvertFahrenheitToCelsius() {
        float actual = ConverterUtil.convertCelsiusToFahrenheit(100);
        float expected = 212;
        assertEquals("Conversion from celsius to fahrenheit failed", expected, actual, 0.001);
    }

    @Test
    public void testConvertCelsiusToFahrenheit() {

        float actual = ConverterUtil.convertFahrenheitToCelsius(212);
        float expected = 100;
        assertEquals("Conversion from fahrenheit to celsius failed", expected, actual, 0.001);
    }
}