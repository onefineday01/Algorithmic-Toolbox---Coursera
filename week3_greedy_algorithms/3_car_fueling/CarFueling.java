import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stop) {
        int stops[] = new int[stop.length+2];
        stops[0]=0;
        stops[stop.length+1] = dist;
        for(int i = 0; i < stop.length; i++)
            stops[i+1] = stop[i];
        int count = 0; 
        int i = 0; 
        int distCovered = 0; 
        while (i <= stop.length)  
        { 
            int last = i;
            while(i <= stop.length && (stops[i+1]-stops[last]) <= tank)
                i++;
            if(i == last) return -1;
            if (distCovered < dist && i != stop.length+1) {
                count++; 
                //System.out.println(stops[i]);
            }
        }
    return count; 
} 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
