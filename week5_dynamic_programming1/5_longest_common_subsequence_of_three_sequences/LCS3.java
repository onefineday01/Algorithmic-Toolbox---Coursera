import java.util.*;

public class LCS3 {
    static int dp[][][];
    static int[] a,b,c;
    private static int lcs3(int i, int j, int k) {
        if (i == -1 || j == -1 || k == -1) 
            return 0; 
        if (dp[i][j][k] != -1)
            return dp[i][j][k];
        if (a[i] == b[j] && b[j] == c[k]) 
            return dp[i][j][k] = 1 + lcs3(i - 1, j - 1, k - 1); 
        else { 
            return dp[i][j][k] = Math.max(Math.max(lcs3(i - 1, j, k), lcs3(i, j - 1, k)),lcs3(i, j, k - 1)); 
        } 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        dp = new int[an][bn][cn];
        for(int a[][] : dp)
            for(int b[] : a)
                Arrays.fill(b, -1);
        System.out.println(lcs3(an-1, bn-1, cn-1));
    }
}

