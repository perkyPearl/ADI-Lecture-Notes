public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ACE";
        int n1 = s1.length();
        int n2 = s2.length();

        System.out.println(LCSTabu(s1, s2, n1, n2));
    }

    static int LCSTabu(String s1, String s2, int n1, int n2){
        int[][] tabu = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tabu[i][j] = 1 + tabu[i - 1][j - 1];
                } else {
                    tabu[i][j] = Math.max(tabu[i - 1][j], tabu[i][j - 1]); 
                }
            }
        }

        return tabu[n1][n2];
    }
}