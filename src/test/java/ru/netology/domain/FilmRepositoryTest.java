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

public class FilmRepositoryTest {
    FilmRepository repo = new FilmRepository();
    FilmItem first = new FilmItem(1, "Terminator");
    FilmItem second = new FilmItem(2, "Die Hard");
    FilmItem third = new FilmItem(3, "Rambo");

    @BeforeEach
    void insertData() {
        FilmRepository repo = new FilmRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    public void saveTest() {
        FilmRepository repo = new FilmRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);
        FilmItem[] actual = repo.findAll();
        FilmItem[] expected = {first, third};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void deleteById(){
        FilmRepository repo = new FilmRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeAll();
        FilmItem[] actual = repo.findAll();
        FilmItem[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindById(){
        FilmRepository repo = new FilmRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.findById(2);
        FilmItem [] actual = repo.findById(2);
        FilmItem[] expected = {second};

        Assertions.assertArrayEquals(expected, actual);
    }

}
