package exercise.second;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BalancedWordsCounterTest {

    @Test
    void shouldReturnAppropriateNumberOfBalancedSubwords() {
        Integer count = BalancedWordsCounter.count("aabbabcccba");
        assertEquals(28, count,
                "There are 28 balanced subwords in \"aabbabcccba\" word.");
    }

    @Test
    void shouldReturnZeroForEmptyInput() {
        Integer count = BalancedWordsCounter.count("");
        assertEquals(0, count, "Should return 0 count for the empty string.");
    }

    @Test
    void shouldThrowRuntimeExceptionForAnyNonLetterCharacters() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> BalancedWordsCounter.count("abababa1"));
        assertEquals("The word cannot contain non-letter characters.", exception.getMessage());
    }

    @Test
    void shouldThrowRuntimeExceptionForNullInput() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> BalancedWordsCounter.count(null));
        assertEquals("The input is null.", exception.getMessage());
    }
}