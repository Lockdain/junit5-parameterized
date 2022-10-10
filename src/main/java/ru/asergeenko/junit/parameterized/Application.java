package ru.asergeenko.junit.parameterized;

import java.util.Objects;

/**
 * Main app.
 */
public class Application {

    /**
     * The limit to split a range.
     */
    private static final int EDGE_LIMIT = 5;

    public boolean isRange(int inputValue) {
        return inputValue <= EDGE_LIMIT;
    }

    /**
     * Checks whether the number is even.
     */
    public boolean isEven(int inputValue) {
        return (inputValue & 1) == 0;
    }

    /**
     * Checks whether the Person's name is assigned (not null).
     */
    public boolean isNameAssigned(Person person) {
        return !Objects.isNull(person.getName());
    }

}
