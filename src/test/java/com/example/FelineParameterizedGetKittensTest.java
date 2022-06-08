package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedGetKittensTest {
    private final int countKittens;
    private final int expectedKittens;

    public FelineParameterizedGetKittensTest(int countKittens, int expectedKittens) {
        this.countKittens = countKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10},
                {25, 25},
        };
    }

    @Test
    public void shouldBeGetKittensCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(countKittens);
        assertEquals(expectedKittens, actual);
    }
}
