// This is a demo task.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

// For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

// Given A = [1, 2, 3], the function should return 4.

// Given A = [−1, −3], the function should return 1.
package CountingElements;

import java.util.Arrays;

public class Task4_MissingInteger {
    public int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Task4_MissingInteger task4 = new Task4_MissingInteger();
        int[] A = { 1, 3, 6, 4, 1, 2 };
        int res = task4.solution(A);
        System.out.println(res);
    }
}
