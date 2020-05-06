//Raj Jain

import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition(int[] A, int i, int s1, int s2, int s3, int sumtotal) {

        if (s1 > sumtotal / 3 || s2 > sumtotal / 3 || s3 > sumtotal / 3) {
            return 0;
        }

        if (i == A.length -1) {
            if (s1 + A[i] == s2 && s2 == s3) return 1;
            if (s1 == s2 + A[i] && s1 == s3) return 1;
            if (s1 == s3 + A[i] && s1 == s2) return 1;
            return 0;
        }

        else {
            int a1 = partition(A, i+1, s1 + A[i], s2, s3, sumtotal);
            if (a1 == 1) return 1;
            int a2 = partition(A, i+1, s1, s2 + A[i], s3, sumtotal);
            if (a2 == 1) return 1;
            int a3 = partition(A, i+1, s1, s2, s3 + A[i], sumtotal);
            if (a3 == 1) return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int totalSum = Arrays.stream(A).reduce(0, (a1,a2) -> a1 + a2);
        System.out.println(partition(A,0,0,0,0,totalSum));
    }
}

