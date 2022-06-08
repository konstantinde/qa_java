package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

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
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldLionHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(lionSex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(isMane, actual);
    }

}
