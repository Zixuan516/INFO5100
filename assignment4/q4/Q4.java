package assignment4.q4;

public class Q4 {
    public int[][] productOf(int[][] A, int[][] B) {
        int[][] AB = new int[A.length][B[0].length];
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B[0].length; j ++){
                AB[i][j] = 0;
                for(int p = 0; p < A[i].length; p ++){
                    AB[i][j] = AB[i][j] + A[i][p] * B[p][j];
                }
            }
        }
        return AB;
    }
}
