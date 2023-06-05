// A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

// A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

// You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

// Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

// For example, consider an integer N = 26 and arrays P, Q such that:

//     P[0] = 1    Q[0] = 26
//     P[1] = 4    Q[1] = 10
//     P[2] = 16   Q[2] = 20
// The number of semiprimes within each of these ranges is as follows:

// (1, 26) is 10,
// (4, 10) is 4,
// (16, 20) is 0.
// Write a function:

// class Solution { public int[] solution(int N, int[] P, int[] Q); }

// that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

// For example, given an integer N = 26 and arrays P, Q such that:

//     P[0] = 1    Q[0] = 26
//     P[1] = 4    Q[1] = 10
//     P[2] = 16   Q[2] = 20
// the function should return the values [10, 4, 0]

package SieveOfEratosthenes;

import java.util.List;

public class Task2_CountSemiprimes {
    public static boolean isPrime(int N) {
        if (N <= 1) {
            return false;
        }
        for (int i = 2; i <= N / 2; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        int l = P.length;
        int[] res = new int[l];
        List<Integer> primes = new java.util.ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        List<Integer> semiprimes = new java.util.ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                int semiprime = primes.get(i) * primes.get(j);
                if (semiprime <= N) {
                    semiprimes.add(semiprime);
                }
            }
        }

        for (int i = 0; i < l; i++) {
            int count = 0;
            for (int j = 0; j < semiprimes.size(); j++) {
                if (semiprimes.get(j) >= P[i] && semiprimes.get(j) <= Q[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 26;
        int[] P = { 1, 4, 16 };
        int[] Q = { 26, 10, 20 };
        int[] res = solution(N, P, Q);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
