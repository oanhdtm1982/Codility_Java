// A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

// Array A contains only 0s and/or 1s:

// 0 represents a car traveling east,
// 1 represents a car traveling west.
// The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

// For example, consider array A such that:

//   A[0] = 0
//   A[1] = 1
//   A[2] = 0
//   A[3] = 1
//   A[4] = 1
// We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

package PrefixSums;

public class Taskk1_PassingCars {
    public int solution(int[] A){
        int count = 0;
        int countZero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0){
                countZero++;
            }
            if (A[i] == 1){
                count += countZero;
            }
        }
        if (count > 1000000000 || count < 0){
            return -1;
        }
        return count;
    }
    public static void main(String[] args) {
        Taskk1_PassingCars taskk1 = new Taskk1_PassingCars();
        int[] A = {0,1,0,1,1};
        int res = taskk1.solution(A);
        System.out.println(res);
    }
}
