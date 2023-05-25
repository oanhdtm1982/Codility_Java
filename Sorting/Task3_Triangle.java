package Sorting;

import java.util.Arrays;

public class Task3_Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (A.length < 3) {
            return 0;
        }
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Task3_Triangle task3 = new Task3_Triangle();
        int[] A = { 10, 2, 5, 1, 8, 20 };
        int res = task3.solution(A);
        System.out.println(res);
    }
}
