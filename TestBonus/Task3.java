package TestBonus;

// given a string S consisting of N lowercase English letters, returns the length of the longest substring in which every letter occurs an even number of times. A substring is defined as a contiguous segment of a string. If no such substring exists, return 0. 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public boolean check(String str) {
        Map<Character, Integer> characterCount = new HashMap<>();

        for (char ch : str.toCharArray()) {
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }

        for (int count : characterCount.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public List<String> findAllEvenSubstrings(String str) {
        List<String> evenSubstrings = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j <= str.length(); j += 2) {
                String substring = str.substring(i, j);
                if (substring.length() % 2 == 0) {
                    evenSubstrings.add(substring);
                }
            }
        }

        return evenSubstrings;
    }

    public int solution(String S) {
        int q = 0;
        List<String> res = findAllEvenSubstrings(S);
        for (String s : res) {
            if (check(s)) {
                q = Math.max(q, s.length());
            }
        }
        return q;
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.solution("zthtzh"));
    }
}
