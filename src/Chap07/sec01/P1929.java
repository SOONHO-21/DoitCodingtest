package Chap07.sec01;

import java.util.Scanner;

public class P1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N+1];

        for(int i=2; i<=N; i++){    //우선 배열 초기화
            A[i] = i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){    //2부터 N의 제곱근 까지 소수 골라내기
            if(A[i] == 0)   //없어도 결과는 나오지만 시간을 아낀다.
                continue;   //Math.sqrt(N)이전 까지 제거되어있던 소수는 거를 수 있다.
            for(int j=i+i; j<=N; j+=i){    //배수 활용
                A[j] = 0;
            }
        }
        for(int i=M; i<=N; i++){
            if(A[i] != 0)
                System.out.println(A[i]);
        }
    }
}