package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println("Активеность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);

    }

    public static void main(String[] args) {
        Error memory = new Error(true, 5, "Out of memory");
        Error err = new Error();
        Error found = new Error(false, 404, "Not Found");
        memory.info();
        err.info();
        found.info();
    }
}
