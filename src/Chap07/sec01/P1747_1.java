package Chap07.sec01;

import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.Scanner;

public class P1747_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[1000001];
        for(int i=2; i<A.length; i++){
            A[i] = i;
        }
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i] == 0)
                continue;
            for(int j=i+i; j< A.length; j += i){
                A[j] = 0;
            }
        }

        int i = N;
        while (true){
            if(A[i] != 0) {   //소수라는 전제하에
                int prime_number = A[i];
                if(isPalindrome(prime_number)){
                    System.out.println(prime_number);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int prime_number){
        char[] ch = String.valueOf(prime_number).toCharArray();
        int s = 0;
        int e = ch.length-1;
        while (s<e){
            if(ch[s] == ch[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}