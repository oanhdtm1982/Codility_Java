// A non-empty array A consisting of N integers is given.

// A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

// For example, the following array A:

//     A[0] = 1
//     A[1] = 5
//     A[2] = 3
//     A[3] = 4
//     A[4] = 3
//     A[5] = 4
//     A[6] = 1
//     A[7] = 2
//     A[8] = 3
//     A[9] = 4
//     A[10] = 6
//     A[11] = 2
// the function should return 3

package PrimeAndCompositeNumbers;

public class Task3_Flags {
    public static int solution(int[] A) {
        int peak_num = 0;
        int[] next_peak = new int[A.length];
        for (int i = A.length - 2; i > 0; i--) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                next_peak[i] = i;
                peak_num++;
            } else {
                next_peak[i] = next_peak[i + 1];
            }
        }

        int result = 0;
        for (int i = peak_num; i > 0 && result < i; i--) {
            int flag_num = 0;
            int flag = next_peak[1];
            while (flag != 0 && flag_num < i) {
                flag_num++;
                if (flag + i >= A.length - 1)
                    break;
                flag = next_peak[flag + i];
            }
            if (flag_num > result)
                result = flag_num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        int res = Task3_Flags.solution(A);
        System.out.println(res);
    }
}
