
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            // Add the new character
            windowFreq[s.charAt(i) - 'a']++;

            // Remove the character leaving the window
            windowFreq[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
