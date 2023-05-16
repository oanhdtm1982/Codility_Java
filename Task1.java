// There is a street described by a string S. Each character in S is one of the following:
// " denotes a car going to the left, denotes a car going to the right,
// ' denotes a speed camera.
// Count the total number of times that cars pass by a speed camera. A car going to the left will pass every speed camera that is to the left of it, and similarly, a car going to the right will pass every speed camera to the right of it.
// Write a function:
// class Solution { public int solution(String S);
// that, given a string S of length N, returns the total number of times that cars pass by a speed camera.
// Examples:
// 1. Given S=".>.
// ., the function should return 3. The car will pass by three speed cameras to the
// right of it.
// 2. Given S = " .>. < .>", the function should return 4. The first two cars will pass by two speed
// cameras each, and the third car will not pass by any.
// 3. Given S - ">>> , <<<", the function should return 6. Each car will pass one speed camera.
// Assume that:
// •N is an integer within the range [1.. 100};
// string S is made only of the following characters: '<, ''and/or'
// In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
public class Task1 {
    public int countDot(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') {
                count++;
            }
        }
        return count;
    }

    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                count = count + countDot(s.substring(0, i));
            } else if (s.charAt(i) == '>') {
                count += countDot(s.substring(i + 1));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(task1.solution(".>..."));
        System.out.println(task1.solution(".>.<.>"));
        System.out.println(task1.solution(">>>.<<<"));
    }
}
