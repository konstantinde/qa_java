package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedAnimalKindTest {

    private final String animalKind;
    private final List<String> expectedAnimalFood;
    private final String exceptionText = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    public AnimalParameterizedAnimalKindTest(String animalKind, List<String> animalFood) {
        this.animalKind = animalKind;
        this.expectedAnimalFood = animalFood;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void shouldBeGetFoodForAnimalKind() throws Exception {
        Animal animal = new Animal();
            List<String> actual = animal.getFood(animalKind);
            assertEquals(expectedAnimalFood, actual);
    }
}
