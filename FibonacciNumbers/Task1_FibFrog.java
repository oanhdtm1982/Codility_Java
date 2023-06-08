// The Fibonacci sequence is defined using the following recursive formula:

//     F(0) = 0
//     F(1) = 1
//     F(M) = F(M - 1) + F(M - 2) if M >= 2
// A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

// The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions start 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

// 0 represents a position without a leaf;
// 1 represents a position containing a leaf.
// The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (start position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

// For example, consider array A such that:

//     A[0] = 0
//     A[1] = 0
//     A[2] = 0
//     A[3] = 1
//     A[4] = 1
//     A[5] = 0
//     A[6] = 1
//     A[7] = 0
//     A[8] = 0
//     A[9] = 0
//     A[10] = 0
// The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

package FibonacciNumbers;

public class Task1_FibFrog {
    public static int solution(int[] A) {
        int[] fib = new int[A.length < 2 ? 2 : A.length + 1];
        fib[0] = 1;
        fib[1] = 2;
        int countNumberFibo = 2;
        while (fib[countNumberFibo - 1] <= A.length) {
            fib[countNumberFibo] = fib[countNumberFibo - 1] + fib[countNumberFibo - 2];
            countNumberFibo++;
        }
        System.out.println("Fibonacci numbers: " + java.util.Arrays.toString(fib));

        int result = -1;
        for (int i = 0; i <= A.length; i++) {
            if (i == A.length || A[i] == 1) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < countNumberFibo && fib[j] <= i + 1; j++) {
                    int start = i - fib[j];
                    if (start == -1) {
                        min = 1;
                    } else if (A[start] > 0) {
                        if (A[start] + 1 < min) {
                            min = A[start] + 1;
                        }
                    }
                }
                if (i < A.length) {
                    if (min == Integer.MAX_VALUE) {
                        A[i] = 0;
                    } else {
                        A[i] = min;
                    }
                } else {
                    if (min != Integer.MAX_VALUE) {
                        result = min;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        System.out.println(solution(A));
    }
}