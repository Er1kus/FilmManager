package ru.netology.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.FilmItem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Manager manager = new Manager();


    FilmItem first = new FilmItem(1, "Terminator");
    FilmItem second = new FilmItem(2, "Die Hard");
    FilmItem third = new FilmItem(3, "Rambo");
    FilmItem forth = new FilmItem(4, "Predator");
    FilmItem fifth = new FilmItem(5, "Alien");
    FilmItem sixth = new FilmItem(6, "Godfather");
    FilmItem seventh = new FilmItem(7, "Game");
    FilmItem eighth = new FilmItem(8, "Fight club");
    FilmItem ninth = new FilmItem(9, "Seven");
    FilmItem tenth = new FilmItem(10, "Inception");
    FilmItem eleventh = new FilmItem(11, "Dark knight");
    FilmItem twelve = new FilmItem(12, "Jurassic world");

    @BeforeEach
    void setData() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(forth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        manager.save(twelve);
    }

    @Test
    public void shouldFindAll() {


        FilmItem[] actual = manager.findAll();
        FilmItem[] expected = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};


        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldShowReverse() {


        FilmItem[] actual = manager.findLast();
        FilmItem[] expected = new FilmItem[]{twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third,};

        assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldShowPart() {
        Manager manager = new Manager();
        FilmItem first = new FilmItem(1, "Terminator");
        FilmItem second = new FilmItem(2, "Die Hard");
        FilmItem third = new FilmItem(3, "Rambo");
        FilmItem forth = new FilmItem(4, "Predator");
        FilmItem fifth = new FilmItem(5, "Alien");
        FilmItem sixth = new FilmItem(6, "Godfather");
        FilmItem seventh = new FilmItem(7, "Game");
        FilmItem eighth = new FilmItem(8, "Fight club");
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(forth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
//        manager.save(ninth);
//        manager.save(tenth);
//        manager.save(eleventh);
//        manager.save(twelve);


        FilmItem[] actual = manager.findLast();
        FilmItem[] expected = new FilmItem[]{eighth, seventh, sixth, fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowLessThanFixed() {
        Manager manager = new Manager(5);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(forth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        manager.save(twelve);

        FilmItem[] actual = manager.findLast();
        FilmItem[] expected = new FilmItem[]{twelve, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, actual);

    }

//    @Test
//    public void shouldShowNull() {
//        Manager manager = new Manager(-5);
//        manager.save(first);
//        manager.save(second);
//        manager.save(third);
//        manager.save(forth);
//        manager.save(fifth);
//        manager.save(sixth);
//        manager.save(seventh);
//        manager.save(eighth);
//        manager.save(ninth);
//        manager.save(tenth);
//        manager.save(eleventh);
//        manager.save(twelve);
//
//        FilmItem[] actual = manager.findLast();
//        FilmItem[] expected = new FilmItem[]{};
//
//        assertArrayEquals(expected, actual);
//
//    }
}
