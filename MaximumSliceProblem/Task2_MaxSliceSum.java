// A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

// For example, given array A such that:

// A[0] = 3  A[1] = 2  A[2] = -6
// A[3] = 4  A[4] = 0
// the function should return 5 because:

// (3, 4) is a slice of A that has sum 4,
// (2, 2) is a slice of A that has sum −6,
// (0, 1) is a slice of A that has sum 5,
// no other slice of A has sum greater than (0, 1).

package MaximumSliceProblem;

public class Task2_MaxSliceSum {
    public static int solution(int[] A) {
        int temp = A[0];
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            temp = Math.max(A[i], temp + A[i]);
            result = Math.max(result, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 3, 2, -6, 4, 0 };
        System.out.println(solution(A));
    }
}
