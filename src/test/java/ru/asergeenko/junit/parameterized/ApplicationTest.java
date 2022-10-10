package ru.asergeenko.junit.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    /**
     * This test uses Csv as an input data/result source.
     * @param inputValue
     * @param result
     */
    @ParameterizedTest
    @CsvSource({
            "200, true", // is below the limit == true
            "5, true", // the exact boundary == true
            "100, false" // far beyond the given limit of 5 -- false
    })
    public void testUseCsvSource(int inputValue, boolean result) {
        var app = new Application();

        assertEquals(result, app.isRange(inputValue), "Oooops!");
    }

    @ParameterizedTest
    @MethodSource("intMethodFactory")
    public void testUsingMethodSource(int inputValue) {
        var app = new Application();

        assertEquals(true, app.isEven(inputValue),"Testing using method source");
    }

    static Stream<Integer> intMethodFactory() {
        return Stream.of(10, 4, 52, 255, 1024);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv")
    public void testUseCsvFileSource(int inputValue, boolean result) {
        var app = new Application();

        assertEquals(result, app.isRange(inputValue), "Oooops!");
    }

    @ParameterizedTest
    @ArgumentsSource(PersonProvider.class)
    public void testUsingArgumentProvider(Person person) {
        var app = new Application();

        assertEquals(true, app.isNameAssigned(person));
    }

}
