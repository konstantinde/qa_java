package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline feline;

    @Test
    public void shouldBeHaveMane() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        boolean actual = lionAlex.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void shouldBeGetFriends() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        List<String> actual = lionAlex.getFriends();
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeGetPlaceOfLiving() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        String actual = lionAlex.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeHaveNotKittens() throws Exception {
        LionAlex lionAlex = new LionAlex(feline);
        int actual = lionAlex.getKittens();
        int expected = 0;
        assertEquals(expected, actual);
    }
}
