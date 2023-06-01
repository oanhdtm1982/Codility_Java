// An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

// For example, consider array A such that

//  A[0] = 3    A[1] = 4    A[2] =  3
//  A[3] = 2    A[4] = 3    A[5] = -1
//  A[6] = 3    A[7] = 3
// The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

// Write a function

// class Solution { public int solution(int[] A); }

// that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

// For example, given array A such that

//  A[0] = 3    A[1] = 4    A[2] =  3
//  A[3] = 2    A[4] = 3    A[5] = -1
//  A[6] = 3    A[7] = 3
// the function may return 0, 2, 4, 6 or 7, as explained above.

package Leader;

public class Task1_Dominator {
    public int solution(int[] A) {
        int count = 0;
        int dominator = 0;

        for (int a : A) {
            if (count == 0) {
                dominator = a;
                count++;
            } else {
                if (dominator == a) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count == 0) {
            return -1;
        }

        int index = 0;
        int countDominator = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                countDominator++;
                index = i;
            }
        }

        if (countDominator > A.length / 2) {
            return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        Task1_Dominator task1 = new Task1_Dominator();
        int[] A = { 3, 4, 3, 2, 3, 3, 3, 4 };
        int res = task1.solution(A);
        System.out.println(res);
    }
}
