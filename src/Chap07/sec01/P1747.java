package Chap07.sec01;

import java.util.Scanner;

public class P1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[1000001];

        for(int i=2; i<A.length; i++){
            A[i] = i;
        }
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i]==0)
                continue;
            for(int j=i+i; j<A.length; j=j+i){
                A[j] = 0;
            }
        }

        int i=N;
        while (true){
            if(A[i] != 0){  //A[i]가 소수이면서
                int result = A[i];
                if(isPalindrome(result)) {     //팰린드롬 수라면
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }
    private static boolean isPalindrome(int prime_number){
        char[] chA = String.valueOf(prime_number).toCharArray();
        int n = 0;
        int m = chA.length-1;

        while (n < m){
            if(chA[n] == chA[m]){
                n++;
                m--;
            } else
                return false;
        }
        return true;
    }
}