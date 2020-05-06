import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> 
            Double.compare((values[b]/(1.0 * weights[b])), (values[a]/(1.0 * weights[a]))));
        for(int i = 0; i < values.length; i++)
            q.add(i);
        while(q.size() > 0 && capacity > 0){
            int x = q.poll();
            if(weights[x] <= capacity){
                value += values[x];
                capacity -= weights[x];
            }
            else{
                value += (values[x]/(1.0 * weights[x]))*capacity;
                capacity=0;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
