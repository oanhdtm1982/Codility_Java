package Sorting;

import java.util.Arrays;

public class Task2_MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);

        int max_1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int max_2 = A[0] * A[1] * A[A.length - 1];

        return Math.max(max_1, max_2);
    }

    public static void main(String[] args) {
        Task2_MaxProductOfThree task2 = new Task2_MaxProductOfThree();
        int[] A = { -3, 1, 2, -2, 5, 6 };
        int res = task2.solution(A);
        System.out.println(res);
    }
}
