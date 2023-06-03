// A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

// For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

// Write a function:

// class Solution { public int solution(int N); }

// that, given a positive integer N, returns the number of its factors.

// For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

package PrimeAndCompositeNumbers;

public class Task1_CountFactors {
    public int solution(int N){
        int count = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0){
                if (N / i == i){
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Task1_CountFactors task1 = new Task1_CountFactors();
        int N = 24;
        int res = task1.solution(N);
        System.out.println(res);
    }
}