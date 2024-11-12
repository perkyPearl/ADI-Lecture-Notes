import java.util.*;

public class MatrixChainMultiplication {
    static int[][] DP;
    static int MCM(int[] arr, int i, int j){
        if(i==j) return 0;

        if(DP[i][j] != -1) return DP[i][j];
        int minimum = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int currMin = MCM(arr, i, k) + MCM(arr, k+1, j)+arr[i-1]*arr[k]*arr[j];
            minimum = Math.min(minimum, currMin);
        }
        DP[i][j] = minimum;

        return DP[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        DP = new int[n][n];
        for (int[] row : DP){
            Arrays.fill(row, -1);
        }

        System.out.println(MCM(arr, 1, n - 1));
    }
}