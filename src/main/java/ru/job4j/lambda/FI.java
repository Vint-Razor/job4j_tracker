package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 2", 120),
                new Attachment("image 3", 23)
        };
        String[] strArr = {
                "zabc",
                "xcdef",
                "ydsert"
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Comparator<String> cmpSize = (left, right) -> left.length() - right.length();
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right)
                -> Integer.compare(right.length(), left.length());
        Arrays.sort(atts, comparator);
        Arrays.sort(strArr, cmpDescSize);
        System.out.println(Arrays.toString(strArr));
    }
}
