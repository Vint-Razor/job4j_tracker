package ru.job4j.ex;

public class FindEl {
    public  static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element Not Found.");
    }

    public static void main(String[] args) {
        String[] arr = {"add", "find", "dog", "kay"};
        try {
            System.out.println(indexOf(arr, "key"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
