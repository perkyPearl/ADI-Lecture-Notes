import java.util.Arrays;

public class CountNoOfWays {
    static int[] memo;
    public static void main(String[] args) {
        int n = 5;

        memo = new int[n+1];

        Arrays.fill(memo, -1);
        System.out.println(countMemo(n));
        System.out.println(countTabu(n));
    }

    static int countMemo(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;

        memo[n] = countMemo(n-1) + countMemo(n-2) + countMemo(n-3);

        return memo[n];
    }

    static int countTabu(int n){
        int[] tabu = new int[n+1];
        tabu[0] = 1;

        for(int i=1;i<=n;i++){
            tabu[i] += tabu[i-1];
            if(i>=2) tabu[i] += tabu[i-2];
            if(i>=3) tabu[i] += tabu[i-3];
        }

        return tabu[n];
    }
}