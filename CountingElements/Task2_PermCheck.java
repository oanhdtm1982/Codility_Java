// A non-empty array A consisting of N integers is given.

// A permutation is a sequence containing each element from 1 to N once, and only once.

// For example, array A such that:

//     A[0] = 4
//     A[1] = 1
//     A[2] = 3
//     A[3] = 2
// is a permutation, but array A such that:

//     A[0] = 4
//     A[1] = 1
//     A[2] = 3
// is not a permutation, because value 2 is missing.


// The goal is to check whether array A is a permutation.

package CountingElements;

import java.util.Arrays;

public class Task2_PermCheck {
    public int solution (int[] A){
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Task2_PermCheck task2 = new Task2_PermCheck();
        int[] A = {4, 1, 2};
        int res = task2.solution(A);
        System.out.println(res);
    }
}
