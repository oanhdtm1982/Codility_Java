// Write a function:

// class Solution { public int solution(int A, int B, int K); }

// that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

// { i : A ≤ i ≤ B, i mod K = 0 }

// For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

package PrefixSums;

public class Task2_CountDiv {
    public int solution(int A, int B, int K) {
        return (B/K) - (A/K) + (A%K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        Task2_CountDiv task2 = new Task2_CountDiv();
        int A = 11;
        int B = 16;
        int K = 17;
        int res = task2.solution(A, B, K);
        System.out.println(res);
    }
}
