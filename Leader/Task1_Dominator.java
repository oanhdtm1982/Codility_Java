package Leader;

public class Task1_Dominator {
    public int solution(int[] A) {
        int count = 0;
        int dominator = 0;

        for (int a : A) {
            if (count == 0) {
                dominator = a;
                count++;
            } else {
                if (dominator == a) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count == 0) {
            return -1;
        }

        int index = 0;
        int countDominator = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                countDominator++;
                index = i;
            }
        }

        if (countDominator > A.length / 2) {
            return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        Task1_Dominator task1 = new Task1_Dominator();
        int[] A = { 3, 4, 3, 2, 3, 3, 3, 4 };
        int res = task1.solution(A);
        System.out.println(res);
    }
}
