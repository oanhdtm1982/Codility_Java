// An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

// The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

// Write a function:

// class Solution { public int[] solution(int[] A, int K); }

// that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
package Arrays;

public class Task1_CyclicRotation {
    public int[] solution(int[] A, int K) {
        int l = A.length;
        int[] res = new int[l];
        for (int i = 0; i < l; i++){
            res[(i + K) % l] = A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Task1_CyclicRotation task1 = new Task1_CyclicRotation();
        int[] A = {3, 8, 9, 7, 6};
        int[] res = task1.solution(A, 3);
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
