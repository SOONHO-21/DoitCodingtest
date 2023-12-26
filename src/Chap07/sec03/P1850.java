package Chap07.sec03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long mgcd = gcd(a, b);

        while (mgcd > 0){
            bw.write(1);
            mgcd--;
        }
        bw.flush();
        bw.close();
    }
    static private long gcd(long a, long b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
}