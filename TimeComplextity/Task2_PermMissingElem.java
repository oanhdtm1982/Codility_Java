// An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

// Your goal is to find that missing element.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A, returns the value of the missing element.

// For example, given array A such that:

//   A[0] = 2
//   A[1] = 3
//   A[2] = 1
//   A[3] = 5
// the function should return 4, as it is the missing element.
package TimeComplextity;

import java.util.Arrays;

public class Task2_PermMissingElem {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        Arrays.sort(A);
        int k = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != k) {
                return k;
            }
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        Task2_PermMissingElem task2 = new Task2_PermMissingElem();
        int[] A = { 2, 3, 4, 1 };
        int res = task2.solution(A);
        System.out.println(res);
    }
}
