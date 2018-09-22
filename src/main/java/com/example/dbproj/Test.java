package com.example.dbproj;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of("a", "b").map(getStringStringFunction()).forEach(System.out::println);
    }

    private static Function<String, String> getStringStringFunction() {
        return v -> v.toUpperCase();
    }

    private static Consumer<String> getStringConsumer() {
        return v -> String.join(" ", v.toUpperCase(), "1");
    }
}
