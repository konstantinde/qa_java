package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

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
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Неизвестный вид");
        } catch (Exception thrown) {
            assertEquals(expected, thrown.getMessage());
        }
    }

    @Test
    public void shouldBeGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

}