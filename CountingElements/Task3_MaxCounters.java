// You are given N counters, initially set to 0, and you have two possible operations on them:

// increase(X) − counter X is increased by 1,
// max counter − all counters are set to the maximum value of any counter.
// A non-empty array A of M integers is given. This array represents consecutive operations:

// if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
// if A[K] = N + 1 then operation K is max counter.
// For example, given integer N = 5 and array A such that:

//     A[0] = 3
//     A[1] = 4
//     A[2] = 4
//     A[3] = 6
//     A[4] = 1
//     A[5] = 4
//     A[6] = 4
// the values of the counters after each consecutive operation will be:

//     (0, 0, 1, 0, 0)
//     (0, 0, 1, 1, 0)
//     (0, 0, 1, 2, 0)
//     (2, 2, 2, 2, 2)
//     (3, 2, 2, 2, 2)
//     (3, 2, 2, 3, 2)
//     (3, 2, 2, 4, 2)
// The goal is to calculate the value of every counter after all operations.

package CountingElements;

public class Task3_MaxCounters {
    public int[] solution(int[] A, int N) {
        int[] counters = new int[N];
        int maxValue = 0;
        int lastMax = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                int counterIndex = A[i] - 1;
                counters[counterIndex] = Math.max(counters[counterIndex], lastMax);
                counters[counterIndex]++;
                maxValue = Math.max(maxValue, counters[counterIndex]);
            } else if (A[i] == N + 1) {
                lastMax = maxValue;
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }

    public static void main(String[] args) {
        Task3_MaxCounters task3 = new Task3_MaxCounters();
        int[] A = { 3, 4, 4, 6, 1, 4, 4 };
        int[] res = task3.solution(A, 5);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
