package com.example;


import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldNotBeManeOnLionFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Test
    public void shouldBeManeOnLionMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void shouldBeExceptionIfIsLionNotFemaleAndNotMale() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Не самец не самка", feline));
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldBeGetFoodLionAsPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", feline);
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeOneKittensLion() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

}
