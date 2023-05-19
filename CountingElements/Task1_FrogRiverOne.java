// A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

// You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

// The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
package CountingElements;

public class Task1_FrogRiverOne {
    public int solution(int X, int[] A) {
        boolean[] positions = new boolean[X + 1];// []
        int uncoveredCount = X; //2

        for (int i = 0; i < A.length; i++) {
            int leafPosition = A[i];//1
            if (leafPosition <= X && !positions[leafPosition]) {
                System.out.println(leafPosition);
                positions[leafPosition] = true;
                uncoveredCount--;
                if (uncoveredCount == 0) {
                    return i;
                }
                System.out.println(positions[leafPosition]);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Task1_FrogRiverOne task1 = new Task1_FrogRiverOne();
        int[] A = { 1, 3, 1, 2 };
        int res = task1.solution(2, A);
        System.out.println(res);
    }
}
