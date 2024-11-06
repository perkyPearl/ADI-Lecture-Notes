import java.util.*;

public class DynamicProgramming {
    static int[] memo;
    static int[] tabu;

    public static int fibonacciDPTabulation(int n) {
        tabu[0] = 0;
        if(n>=1){
            tabu[1] = 1;
        }
        
        for(int i=2;i<=n;i++){
            tabu[i] = tabu[i-1] + tabu[i-2];
        }

        return tabu[n];
    }

    public static int fibonacciDPMemo(int n) {
        if(n <= 1) return n;

        if(memo[n] != -1) return memo[n];

        memo[n] = fibonacciDPMemo(n-1) + fibonacciDPMemo(n-2);

        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        memo = new int[n+1];
        tabu = new int[n+1];

        Arrays.fill(memo, -1);
        Arrays.fill(tabu, -1);
        System.out.println("Fibonacci Series: " + fibonacciDPTabulation(n));
        System.out.println("Fibonacci Series: " + fibonacciDPMemo(n));

        sc.close();
    }
}
