import java.util.*;

public class ChangeDP {
	static int deno[];
    private static int getChange(int m) {
        //write your code here
        int mindp[] = new int[m+1];
        mindp[0] = 0;
        for (int i = 1; i <= m; i++){
        	mindp[i] = Integer.MAX_VALUE;
        	for(int coin : deno){
        		if(i >= coin){
        			int coins = mindp[i - coin] + 1;
        			if(mindp[i] > coins)
        				mindp[i] = coins;
        		}
        	}
        }
        return mindp[m];
    }
    public static void main(String[] args) {
    	deno  =  new int[]{1,3,4};
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

