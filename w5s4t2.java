import java.util.*;

class Solution {

public List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> result = new ArrayList<>();

    for (String word : words) {
        if (matches(word, pattern)) {
            result.add(word);
        }
    }

    return result;
}

private boolean matches(String word, String pattern) {

    Map<Character, Character> map = new HashMap<>();
    Map<Character, Character> reverseMap = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {

        char p = pattern.charAt(i);
        char w = word.charAt(i);

        // Pattern character already has a different mapping
        if (map.containsKey(p) && map.get(p) != w) {
            return false;
        }

        // Word character is already mapped from another pattern character
        if (reverseMap.containsKey(w) && reverseMap.get(w) != p) {
            return false;
        }

        map.put(p, w);
        reverseMap.put(w, p);
    }

    return true;
}


}
