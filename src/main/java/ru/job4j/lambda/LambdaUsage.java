package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strArr = {
          "abc",
          "defg",
          "asdfrt"
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(strArr, cmpDescSize);
        System.out.println(Arrays.toString(strArr));
    }
}
