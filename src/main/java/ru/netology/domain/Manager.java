package ru.netology.domain;

public class Manager {
    private int amountFilm = 10;


    public Manager() {
    }

    public Manager(int amountFilm) {
//        if (amountFilm <= 0) {
//            throw new RuntimeException(
//                    "Нужно положительные числа передавать," +
//                            "а ты указал:'" + amountFilm + "'"
//            );
//        }
        this.amountFilm = amountFilm;
    }

    private FilmItem[] items = new FilmItem[0];

    public FilmItem[] save(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
        return items;
    }

    public FilmItem[] findAll() {
        return items;
    }

    public FilmItem[] findLast() {
        int length = this.amountFilm;
        if (length > items.length) {
            length = items.length;
        }
        FilmItem[] result = new FilmItem[length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}





