import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int [][] dp = new int [W + 1][w.length + 1];
        for (int wei = 0; wei <= W; wei++) {
            for (int i = 0; i<= w.length; i++) {

                if (i == 0 || wei == 0) {
                    // Item 0 or wei 0
                    dp[wei][i] = 0;
                } else {
                    int UsenotIthItem = dp[wei][i-1];

                    // dpimising Problem -> Need to Set to - INFINITY
                    int useIthItem = Integer.MIN_VALUE;

                    // Check if there is enough wei for ith Item
                    // ith Item's wei is w[i-1]
                    if (wei - w[i-1] >= 0) {
                        useIthItem = dp[wei - w[i-1]][i-1] + w[i-1];
                    }

                    dp[wei][i] = Math.max(useIthItem, UsenotIthItem);
                }
            }
        }

        return dp[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
