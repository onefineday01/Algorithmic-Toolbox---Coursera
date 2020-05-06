import java.util.*;

public class MaxPairwiseProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max1=0, max2=0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(max1 <= x){
                max2=max1;
                max1=x;
                
            }
            else if(max2 <= x ){
                max2=x;
            }
        }
        System.out.println(max1 * max2);
    }
}
    