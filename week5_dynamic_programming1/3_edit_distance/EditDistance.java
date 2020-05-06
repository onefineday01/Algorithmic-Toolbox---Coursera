import java.util.*;

class EditDistance {
  static int min(int x, int y, int z) 
    { 
        if (x <= y && x <= z) 
            return x; 
        if (y <= x && y <= z) 
            return y; 
        else
            return z; 
    } 
  public static int editDistance(String str1, String str2, int m, int n) {
    //write your code here
      int dp[][] = new int[m + 1][n + 1]; 
      for (int i = 0; i <= m; i++) { 
          for (int j = 0; j <= n; j++) { 
              if (i == 0) 
                  dp[i][j] = j;
              else if (j == 0) 
                  dp[i][j] = i;
              else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                  dp[i][j] = dp[i - 1][j - 1];
              else
                  dp[i][j] = 1 + min(dp[i][j - 1], // Insert 
                                   dp[i - 1][j], // Remove 
                                   dp[i - 1][j - 1]); // Replace 
          } 
      } 
      return dp[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t, s.length(), t.length()));
  }

}
