package ru.netology.domain;

public class FilmRepository {
    private FilmItem[] items = new FilmItem[0];

    public void save(FilmItem item) {
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] findAll() {
        return items;
    }


    public void removeById(int id) {
        int length = items.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public FilmItem[] removeAll() {
        items = new FilmItem[0];
        return new FilmItem[0];
    }


    public FilmItem[] findById(int id) {
        for (FilmItem item : items) {
            if (item.getId() == id) {
                return new FilmItem[]{item};
            }
        }
        return new FilmItem[0];
    }
}