package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", (short) 450);
        Book java = new Book("Java", (short) 1500);
        Book html = new Book("HTML", (short) 150);
        Book cpp = new Book("C++", (short) 1700);
        Book[] lib = new Book[4];
        lib[0] = cleanCode;
        lib[1] = java;
        lib[2] = html;
        lib[3] = cpp;
        libPrint(lib);
        libSwap(lib, 0, 3);
        libPrint(lib);
        System.out.println(bookFind(lib, "Clean code"));
    }

    public static void libPrint(Book[] lib) {
        for (int i = 0; i < lib.length; i++) {
            System.out.println("название: " + lib[i].getName()
                    + " колич. страниц: " + lib[i].getPages());
        }
        System.out.println();
    }

    public static void libSwap(Book[] lib, int first, int second) {
        Book temp = lib[first];
        lib[first] = lib[second];
        lib[second] = temp;
    }

    public static String bookFind(Book[] lib, String name) {
        for (int i = 0; i < lib.length; i++) {
            if (lib[i].getName().equals(name)) {
                return "Книга: \"" + lib[i].getName() + "\" индекс: " + i;
            }
        }
        return "Книга не найдена";
    }
}
