package Sorting;

public class Task4_NumberOfDiscIntersections {
    public int solution(int[] A) {
        int n = A.length;
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            int right;

            if (n - i - 1 >= A[i]) {
                right = i + A[i];
            } else {
                right = n - 1;
            }

            sum[right]++;
        }

        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }

        long ans = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {
            int left;

            if (A[i] > i) {
                left = 0;
            } else {
                left = i - A[i];
            }
            if (left > 0) {
                ans -= sum[left - 1];
            }
        }

        if (ans > 10000000) {
            return -1;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Task4_NumberOfDiscIntersections task4 = new Task4_NumberOfDiscIntersections();
        int[] A = { 1, 5, 2, 1, 4, 0 };
        int res = task4.solution(A);
        System.out.println(res);
    }
}
