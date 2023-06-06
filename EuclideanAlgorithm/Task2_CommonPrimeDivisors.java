// A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

// A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

// You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

// For example, given:

// N = 15 and M = 75, the prime divisors are the same: {3, 5};
// N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
// N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
// Write a function:

// class Solution { public int solution(int[] A, int[] B); }

// that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

// For example, given:

//     A[0] = 15   B[0] = 75
//     A[1] = 10   B[1] = 30
//     A[2] = 3    B[2] = 5
// the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

package EuclideanAlgorithm;

public class Task2_CommonPrimeDivisors {
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int solution(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int gcdAB = gcd(A[i], B[i]);
            int gcdA = 0;
            int gcdB = 0;
            while (A[i] != 1) {
                gcdA = gcd(A[i], gcdAB);
                if (gcdA == 1) {
                    break;
                }
                A[i] = A[i] / gcdA;
            }
            if (A[i] != 1) {
                continue;
            }
            while (B[i] != 1) {
                gcdB = gcd(B[i], gcdAB);
                if (gcdB == 1) {
                    break;
                }
                B[i] = B[i] / gcdB;
            }
            if (B[i] != 1) {
                continue;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 15, 10, 5 };
        int[] B = { 75, 30, 10 };
        System.out.println(solution(A, B));
    }
}
