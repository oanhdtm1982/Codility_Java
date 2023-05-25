package Sorting;

import java.util.Arrays;

public class Task1_Distinct {
    public int solution(int[] A) {
        if (A.length == 0)
            return 0;

        int result = 1;

        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Task1_Distinct task1 = new Task1_Distinct();
        int[] A = { 2, 1, 1, 2, 3, 1 };
        int res = task1.solution(A);
        System.out.println(res);
    }
}
