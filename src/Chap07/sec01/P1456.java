package Chap07.sec01;

import java.util.Scanner;

public class P1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Min = sc.nextInt();
        int Max = sc.nextInt();
        int[] A = new int[10000001];
        for(int i=2; i<10000001; i++){
            A[i] = i;
        }
        for(int i=2; i<10000001; i++){
            if(A[i] == 0)
                continue;
            for(int j = i+i; j<10000001;j += i){    //배수 지우기
                A[j] = 0;
            }
        }
        int count = 0;
        for(int i=2; i<10000001; i++){
            int temp = A[i];
            while((double)Max/(double)temp >= (double)A[i]) {
                if((double)Min/(double)temp <= (double)A[i]) {
                    count++;
                }
                temp *= A[i];
            }
        }
        System.out.println(count);
    }
}