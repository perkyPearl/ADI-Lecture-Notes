import java.util.*;

public class LongestCommonSubsequence {
    static int[][] DP;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = "ABCDE";
        String s2 = "ACE";
        int n1 = 5;
        int n2 = 3;

        DP = new int[n1+1][n2+1];

        for(int[] row: DP){
            Arrays.fill(row, -1);
        }

        System.out.println(LCSFinder(s1, s2, n1, n2));
        
        for(int[] row: DP){
            for(int val: row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static int LCSFinder(String s1, String s2, int l1, int l2){
        if(l1 == 0 || l2 == 0) return 0;

        if(s1.charAt(l1-1) == s2.charAt(l2-1)){
            DP[l1][l2] = 1 + LCSFinder(s1, s2, l1-1, l2-1);
        }
        else{
            DP[l1][l2] = Math.max(LCSFinder(s1, s2, l1-1, l2),LCSFinder(s1, s2, l1, l2-1));
        }

        return DP[l1][l2];
    }
}
