package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    @Test
    public void shouldBeGetFoodForHerbivoreAnimalKind() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeGetFoodForPredatorAnimalKind() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeGetExceptionWhenGetFoodForOtherAnimalKind() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Неизвестный"));
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldBeGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

}
