package exercise.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedWordsCounter {
    public static Integer count(String input) {
        if (input == null) {
            throw new RuntimeException("The input is null.");
        }
        List<String> stringList = findSubwords(input);
        int counter = 0;
        for (String s : stringList) {
            if (checkBalancedWord(s)) {
                counter++;
            }
        }
        return counter;
    }

    private static List<String> findSubwords(String word) {
        List<String> subwords = new ArrayList<>();
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j <= word.length() - i; j++) {
                int p = j + i - 1;
                subwords.add(word.substring(j, p + 1));
            }
        }
        return subwords;
    }

    private static boolean checkBalancedWord(String word) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (c < 97 || c > 122) {
                throw new RuntimeException("The word cannot contain non-letter characters.");
            }
            if (!letters.containsKey(c)) {
                letters.put(c, 1);
            } else {
                letters.replace(c, letters.get(c) + 1);
            }
        }
        Integer temp = null;
        boolean key = true;
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (temp != null && !entry.getValue().equals(temp)) {
                key = false;
                break;
            }
            temp = entry.getValue();
        }
        return key;
    }
}
