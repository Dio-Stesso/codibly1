package exercise.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
    @Test
    void shouldReturnSortedNaturalNumbers() {
        List<Integer> input = List.of(1, 4, 5, 6, 8, 3, 8);
        List<Integer> result = List.of(1, 3, 4, 5, 6, 8, 8);
        assertEquals(result, BubbleSort.sort(input),
                "The sort method should return ascending sorted list.");

    }

    @Test
    void shouldReturnSortedNumbers() {
        List<Double> input = List.of(-9.3, 0.2, 4.0, 0.1, 5.0, 9.0);
        List<Double> result = List.of(-9.3, 0.1, 0.2, 4.0, 5.0, 9.0);
        assertEquals(result, BubbleSort.sort(input),
                "The sort method should return ascending sorted list.");
    }

    @Test
    void shouldReturnEmptyList() {
        List<Integer> input = List.of();
        assertEquals(Collections.emptyList(), BubbleSort.sort(input),
                "The sort method should return empty list.");
    }

    @Test
    void shouldAvoidNullValue() {
        List<Double> input = new ArrayList<>();
        input.add(null);
        input.add(5.0001);
        List<Double> result = List.of(5.0001);
        assertEquals(result, BubbleSort.sort(input),
                "The sort method should avoid null value.");
    }

    @Test()
    void shouldThrowRuntimeExceptionOnNullValue() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> BubbleSort.sort(null));
        assertEquals("The list is null.", exception.getMessage());
    }
}