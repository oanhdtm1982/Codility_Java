// A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

// The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

// For example, consider string S = CAGCCTA and arrays P, Q such that:

//     P[0] = 2    Q[0] = 4
//     P[1] = 5    Q[1] = 5
//     P[2] = 0    Q[2] = 6
// The answers to these M = 3 queries are as follows:

// The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
// The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
// The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.

package PrefixSums;

public class Task3_GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] genoms = new int[3][S.length() + 1];
        short a, c, g;

        for (int i = 0; i < S.length(); i++) {
            a = 0;
            c = 0;
            g = 0;
            if ('A' == (S.charAt(i))) {
                a = 1;
            }
            if ('C' == (S.charAt(i))) {
                c = 1;
            }
            if ('G' == (S.charAt(i))) {
                g = 1;
            }

            genoms[0][i + 1] = genoms[0][i] + a;
            genoms[1][i + 1] = genoms[1][i] + c;
            genoms[2][i + 1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int fromIndex = P[i] + 1;
            int toIndex = Q[i] + 1;

            if (genoms[0][toIndex] - genoms[0][fromIndex - 1] > 0) {
                result[i] = 1;
            } else if (genoms[1][toIndex] - genoms[1][fromIndex - 1] > 0) {
                result[i] = 2;
            } else if (genoms[2][toIndex] - genoms[2][fromIndex - 1] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Task3_GenomicRangeQuery obj = new Task3_GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = { 2, 5, 0 };
        int[] Q = { 4, 5, 6 };
        int[] result = obj.solution(S, P, Q);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
