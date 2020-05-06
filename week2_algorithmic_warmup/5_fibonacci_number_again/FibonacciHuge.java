//Raj Jain

import java.util.*;

class FibonacciHuge
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            long m = sc.nextLong();
            long rem = n % get_pisano_period(m);
            long f = 0;
            long s = 1;
            long ans = rem;
            for(int i = 1; i < rem; i++){
                ans = (f + s) % m;
                f =s;
                s = ans;
            }
            System.out.println(ans % m);            
    }
    static long get_pisano_period(long m) {
        long a = 0, b = 1;
        long c = a + b;
        long length = 0;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                length = i+1;
                break;
            }
        }
        return length;
    }
}
