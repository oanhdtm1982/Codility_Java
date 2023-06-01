// A non-empty array A consisting of N integers is given.

// The leader of this array is the value that occurs in more than half of the elements of A.

// An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

// For example, given array A such that:

//     A[0] = 4
//     A[1] = 3
//     A[2] = 4
//     A[3] = 4
//     A[4] = 4
//     A[5] = 2
// we can find two equi leaders:

// 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
// 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
// The goal is to count the number of equi leaders.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

// For example, given:

//     A[0] = 4
//     A[1] = 3
//     A[2] = 4
//     A[3] = 4
//     A[4] = 4
//     A[5] = 2
// the function should return 2, as explained above.

package Leader;

public class Task2_EquiLeader {
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
            return 0;
        }

        int countDominator = 0;

        for (int i : A) {
            if (i == dominator) {
                countDominator++;
            }
        }

        if (countDominator <= A.length / 2) {
            return 0;
        }

        int equiCount = 0;
        int result = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == dominator)
                equiCount++;

            boolean leftLeader = equiCount > (i + 1) / 2;
            boolean rightLeader = (countDominator - equiCount) > (A.length - i - 1) / 2;
            if (leftLeader && rightLeader)
                result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Task2_EquiLeader task2 = new Task2_EquiLeader();
        int[] A = { 4, 3, 4, 4, 4, 2 };
        int res = task2.solution(A);
        System.out.println(res);
    }
}
