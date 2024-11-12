public class KnapsackTabu {
    static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] tabu = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    tabu[i][w] = 0;
                } 
                else if (wt[i - 1] <= w) {
                    tabu[i][w] = Math.max(val[i - 1] + tabu[i - 1][w - wt[i - 1]], tabu[i - 1][w]);
                }else{
                    tabu[i][w] = tabu[i - 1][w];
                }
            }
        }
        return tabu[n][W];
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;

        System.out.println(knapsack(wt, val, W, n));
    }
}