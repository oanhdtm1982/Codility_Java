// Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

// You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

// You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

// More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

// You stop eating when you encounter an empty wrapper.

// For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

// The goal is to count the number of chocolates that you will eat, following the above rules.

// Write a function:

// class Solution { public int solution(int N, int M); }

// that, given two positive integers N and M, returns the number of chocolates that you will eat.

// For example, given integers N = 10 and M = 4. the function should return 5

package EuclideanAlgorithm;

public class Task1_ChocolatesByNumbers {
    // public int solution(int N, int M) {
    //     int[] chocolates = new int[N];
    //     int count = 0;
    //     int i = 0;
    //     while (chocolates[i] == 0) {
    //         chocolates[i] = 1;
    //         count++;
    //         i = (i + M) % N;
    //     }
    //     return count;
    // }
//Score: 62%

    //gcd(N, M) is the greatest common divisor of integers N and M.
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int solution(int N, int M) {
        return N / gcd(N, M);
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 4;
        System.out.println(solution(N, M));
    }
}
