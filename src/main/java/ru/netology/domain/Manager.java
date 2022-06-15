package ru.netology.domain;

public class Manager {
    private FilmRepository repository;
    private int amountFilm = 10;

    public Manager(FilmRepository repository) {
        this.repository = repository;
        this.amountFilm = 10;
    }
    public Manager(int amountFilm){
        this.amountFilm = amountFilm;
    }

    public void add(FilmItem item) {
        repository.save(item);
    }


    public FilmItem[] findLast() {
        int length = this.amountFilm;
        FilmItem[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }
        FilmItem[] result = new FilmItem[items.length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public FilmItem[] findAll() {
        FilmItem[] items = repository.findAll();
        FilmItem[] result = new FilmItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}












