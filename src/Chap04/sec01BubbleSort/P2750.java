package Chap04.sec01BubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int temp;
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<N-1-i; j++) {
                if(A[j] > A[j+1]) {
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i=0; i<N-1; i++) {
            System.out.println(A[i]);
        }
    }
}