package Chap04.sec06RadixSort;

import java.io.*;

public class P10989 {
    public static int[] A;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A, 5);
    }
    public static void Radix_Sort(int[] A, int max_size) {
        int[] outPut = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) {     //최대 자릿수(5)를 넘지 않는 다면
            int[] bucket = new int[10];
            for(int i=0; i<A.length; i++){
                bucket[(A[i]/jarisu) % 10]++;   //일의 자리 수부터 하기
            }
            for(int i=0; i<A.length; i++){
                bucket[i] = bucket[i-1];
            }
            for(int i=A.length; i>=0; i++){
                outPut[bucket[(A[i]/jarisu%10)] -1] = A[i]; //자리수 기준으로 정렬
                bucket[(A[i]/jarisu%10)]--;
            }
            for(int i=A.length; i>=0; i++){
                A[i] = outPut[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
