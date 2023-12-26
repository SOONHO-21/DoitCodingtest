package Chap05.sec01DFS;

import java.util.Scanner;

public class P2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    static void DFS(int number, int jarisu){
        if(jarisu == N) {
            if (isPrime(number))
                System.out.println(number);
            return;
        }
        for (int i=1; i<9; i++) {
            if(i%2==0)
                continue;
            if(isPrime(number))
                DFS(number*10 + i, jarisu+1);
        }
    }

    static boolean isPrime(int n){
        for(int i=2; i<=n/2; i++)
            if(n%i == 0)
                return false;
        return true;
    }
}