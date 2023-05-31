package TestBonus;
// There are N hospitals, numbered from 0 to N-1. You are given a schedule of work in each of the hospitals for the following M days. The schedule is provided in the form of a two-dimensional array A containing N rows, each row representing the schedule of one hospital, and M columns, each column representing one day. Integer A[K]IL] (for K within the range [0..N-1] and L within the range
// 10..M-1]) represents the ID of the doctor working at hospital K on day L. Note that sometimes an individual doctor may work at more than one hospital even on the same day.
// Write a function:
// class Solution { public int solution(int[Ill A); }
// that, given a matrix A consisting of N rows and M columns representing the hospitals schedules, finds the number of doctors working at more than one hospital
import java.util.*;

public class Task2 {
    public int solution(int[][] A) {
        int count = 0;
        int N = A.length;
        int M = A[0].length;

        Map<Integer, Set<Integer>> doctorCount = new HashMap<>();

        for (int hospital = 0; hospital < N; hospital++) {
            for (int day = 0; day < M; day++) {
                int doctorID = A[hospital][day];
                if (!doctorCount.containsKey(doctorID)) {
                    doctorCount.put(doctorID, new HashSet<>());
                }
                doctorCount.get(doctorID).add(hospital);
            }
        }

        for (Set<Integer> hospitals : doctorCount.values()) {
            if (hospitals.size() > 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        int[][] A = { { 1, 1, 5, 2, 3 }, { 4, 5, 6, 4, 3 }, { 9, 4, 4, 1, 5 } };
        int[][] B = { { 1, 2, 2 }, { 3, 1, 4 } };
        int[][] C = { { 4, 3 }, { 5, 5, }, { 6, 2 } };
        System.out.println(task2.solution(B));
        System.out.println(task2.solution(A));
        System.out.println(task2.solution(C));
    }
}
