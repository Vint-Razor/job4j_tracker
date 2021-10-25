package ru.job4j.strategy;

public class Paint {
    public void drawShape(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.drawShape(new Triangle());
        paint.drawShape(new Square());
    }
}
