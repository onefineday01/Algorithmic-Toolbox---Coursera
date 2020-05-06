//Raj Jain

import java.util.*;
import java.io.*;

class LCM
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long ans = 1;
        ans *= a;
        ans *= b;
        ans /= gcd(a,b);
        System.out.println(ans);
    }
    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}
