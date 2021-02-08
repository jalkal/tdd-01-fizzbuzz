package com.merkleinc.tdd.fizzbuzz;


import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {

    private final Printer printer;
    public FizzBuzz(Printer printer) {
        this.printer = printer;
    }

    public void execute() {
        printer.print(rangeClosed(1,100).mapToObj(this::mapNumber).collect(toList()));
    }

    private String mapNumber(int number) {
        if(isFizz(number) && isBuzz(number)){
            return "FizzBuzz";
        }
        if(isFizz(number)){
            return "Fizz";
        }
        if(isBuzz(number)){
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public boolean isBuzz(int number) {
        return number%5==0;
    }

    public boolean isFizz(int number) {
        return number%3==0;
    }
}