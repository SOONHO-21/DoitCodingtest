package Chap11;

import java.io.*;
import java.util.StringTokenizer;

public class P13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] D = new int[N];
        int[] L = new int[N];
        int[] R = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        L[0] = A[0];
        int result = L[0];
        for(int i=1; i<L.length; i++){
            L[i] = Math.max(A[i], L[i-1] + A[i]);
            result = Math.max(L[i], result);
        }
        R[N-1] = A[N-1];
        for(int i=R.length-2; i>=0; i--){
            R[i] = Math.max(A[i], R[i+1] + A[i]);
        }
        for(int i=1; i<N-1; i++){
            int temp = L[i-1] + R[i+1];
            result = Math.max(result, temp);
        }
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}