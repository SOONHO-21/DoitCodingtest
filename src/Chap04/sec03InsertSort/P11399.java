package Chap04.sec03InsertSort;

import java.util.Arrays;
import java.util.Scanner;

public class P11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        //삽입 정렬
        for(int i=1; i<N; i++){
            int insertPoint = i;
            int insertValue = A[i];
            for(int j = i-1; j >= 0; j--){
                if(A[j] < A[i]) {   //A[i]가 더 크면 앞에 있는 A[j] 다음으로 가야 한다
                    insertPoint = j+1;  //그래서 A[i]가 들어갈 insertPoint는 j+1이 된다
                    break;
                }
                if(j==0) {
                    insertPoint = 0;
                }
            }
            for(int j = i; j > insertPoint; j--) {    //시프트 연산(이건 그냥 외우기) 왼->오는 안 된다
                A[j] = A[j - 1];
            }
            A[insertPoint] = insertValue;
        }

        S[0] = A[0];
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + A[i];
        }
        int sum=0;
        for(int i=0; i<N; i++){
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
}