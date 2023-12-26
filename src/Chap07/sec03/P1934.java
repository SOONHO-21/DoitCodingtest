package Chap07.sec03;

import java.util.Scanner;

public class P1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for(int i=0; i<times; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a*b/gcd(a, b);
            //a*b/(최대 공약수) = (최소 공배수)
            System.out.println(result);
        }
    }
    private static int gcd(int a, int b){   //최대 공약수를 구하는 함수
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
}