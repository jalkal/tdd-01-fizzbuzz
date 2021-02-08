package com.merkleinc.tdd.fizzbuzz;

import java.util.List;

public interface Printer {

    default void print(List<String> elementsToPrint){
        elementsToPrint.forEach(System.out::println);
    }
}
