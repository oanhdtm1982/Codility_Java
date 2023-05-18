package TimeComplextity;

public class Task3_TapeEquilibrium {
    public int solution(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        int minDiff = Integer.MAX_VALUE;
        int leftSum = 0;

        for (int p = 0; p < A.length - 1; p++) {
            leftSum += A[p];
            int rightSum = sum - leftSum;
            int diff = Math.abs(leftSum - rightSum);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        Task3_TapeEquilibrium task3 = new Task3_TapeEquilibrium();
        int[] A = { 3, 1, 2, 4, 3 };
        int res = task3.solution(A);
        System.out.println(res);
    }
}
