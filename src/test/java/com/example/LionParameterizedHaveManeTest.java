package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionParameterizedHaveManeTest {

    private final String lionSex;
    private final boolean isMane;
    private final String expectedExceptionText = "Используйте допустимые значения пола животного - самец или самка";

    public LionParameterizedHaveManeTest(String lionSex, boolean isMane) {
        this.lionSex = lionSex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters
    public static Object[][] getHaveManeData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Оно", false},
        };
    }

    @Test
    public void shouldLionHaveManeOrException() {
        Feline feline = new Feline();
        try {
            Lion lion = new Lion(lionSex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(isMane, actual);
        } catch (Exception thrown) {
            assertEquals(expectedExceptionText, thrown.getMessage());
        }
    }

}
