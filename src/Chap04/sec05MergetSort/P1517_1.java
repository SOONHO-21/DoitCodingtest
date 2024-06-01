package Chap04.sec05MergetSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_1 {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++)
            A[i] = Integer.parseInt(st.nextToken());
        result = 0;
        merget_sort(1, N);
        System.out.println(result);
    }
    public static void merget_sort(int s, int e) {

    }
}
