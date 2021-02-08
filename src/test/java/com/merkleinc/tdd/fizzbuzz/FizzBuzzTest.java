package com.merkleinc.tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {


    private TestPrinter testPrinter;

    @BeforeEach
    public void setup() {

        //Given
        testPrinter = new TestPrinter();
        FizzBuzz fizzBuzz = new FizzBuzz(testPrinter);

        //When
        fizzBuzz.execute();
    }

    @Test
    public void prints_100_elements() {

        //Then
        assertEquals(testPrinter.getElementsToPrint().size(), 100);
    }

    @Test
    public void prints_numbers_no_multiple_of_3_nor_5() {

        //Then
        assertEquals( "1", getFizzBuzzNumber(1));
        assertEquals( "2", getFizzBuzzNumber(2));
        assertEquals( "98", getFizzBuzzNumber(98));
    }

    @Test
    public void prints_Fizz_when_multiple_of_3() {

        //Then
        assertEquals( "Fizz", getFizzBuzzNumber(3));
        assertEquals( "Fizz", getFizzBuzzNumber(6));
        assertEquals( "Fizz", getFizzBuzzNumber(99));
    }

    @Test
    public void prints_Fizz_when_multiple_of_5() {

        //Then
        assertEquals( "Buzz", getFizzBuzzNumber(5));
        assertEquals( "Buzz", getFizzBuzzNumber(10));
        assertEquals( "Buzz", getFizzBuzzNumber(95));
    }

    @Test
    public void prints_FizzBuzz_when_multiple_of_3_and_5() {

        //Then
        assertEquals( "FizzBuzz", getFizzBuzzNumber(15));
        assertEquals( "FizzBuzz", getFizzBuzzNumber(30));
        assertEquals( "FizzBuzz", getFizzBuzzNumber(60));
    }


    public String getFizzBuzzNumber(int i) {
        return testPrinter.getElementsToPrint().get(i - 1);
    }

    static class TestPrinter implements Printer{
        List<String> elementsToPrint;

        @Override
        public void print(List<String> elementsToPrint) {
            this.elementsToPrint = elementsToPrint;
        }

        public List<String> getElementsToPrint() {
            return elementsToPrint;
        }
    }
}