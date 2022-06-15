package ru.netology.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.domain.FilmItem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ManagerTest {
    @Mock
    private FilmRepository repository = Mockito.mock(FilmRepository.class);
    @InjectMocks
    private Manager manager = new Manager(repository);

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

    @Test
    public void shouldShowAll() {
        FilmItem[] returned = {first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository).findAll();

        FilmItem[] actual = manager.findAll();
        FilmItem[] expected = {twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowLast() {
        FilmItem[] returned = {twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};
        doReturn(returned).when(repository).findAll();

        FilmItem[] actual = manager.findLast();
        FilmItem[] expected = new FilmItem[]{third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

}

