package exercise.first;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BubbleSort {
    public static List<Comparable> sort(List<? extends Comparable> input) {
        if (input == null) {
            throw new RuntimeException("The list is null.");
        }
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return process((List<Comparable>) input);
    }

    private static List<Comparable> process(List<Comparable> list) {
        List<Comparable> result = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i; j < result.size() - 1; j++) {
                if (result.get(i).compareTo(result.get(j + 1)) > 0) {
                    Collections.swap(result, j + 1, i);
                }
            }
        }
        return result;
    }
}
