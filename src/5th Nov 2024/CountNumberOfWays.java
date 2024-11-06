import java.util.Arrays;
import java.util.Scanner;

public class CountNumberOfWays {
    static int[] memo;
    static int[] tabu;

    static int counterMemo(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (memo[n] != -1) return memo[n];

        memo[n] = counterMemo(n - 1) + counterMemo(n - 2) + counterMemo(n - 3);

        return memo[n];
    }

    static int counterTabu(int n) {
        tabu[0] = 1;

        for (int i = 1; i <= n; i++) {
            tabu[i] = tabu[i - 1];
            if (i >= 2){
                tabu[i] += tabu[i - 2];
            }
            if (i >= 3){
                tabu[i] += tabu[i - 3];
            }
        }

        return tabu[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of steps (n): ");

        int n = sc.nextInt();

        memo = new int[n + 1];
        tabu = new int[n + 1];
        Arrays.fill(memo, -1);
        Arrays.fill(tabu, -1);

        System.out.println("Number of Ways: " + counterMemo(n));
        System.out.println("Number of Ways: " + counterTabu(n));
    }
}
