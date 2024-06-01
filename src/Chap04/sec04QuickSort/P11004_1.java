package Chap04.sec04QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }
    public static void quickSort(int[] A, int S, int E, int K) {
        if(S < E) {
            int pivot = partition(A, S, E);     //피벗 구하기
            if(pivot == K)
                return;
            else if (pivot > K){
                quickSort(A, S, pivot-1, K);
            }
            else {
                quickSort(A, pivot+1, E, K);
            }
        }
    }
    private static int partition(int[] A, int S, int E) {    //이 다음의 피벗을 구하는 로직
        if(S + 1 == E) {
            if (A[S] > A[E]) swap(A, S, E);
            return E;
        }
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];   //기존 중앙값이 A[S]가 된 상태
        int i = S;
        int j = E;
        while (i < j){
            while (i > S && pivot > A[i])
                i++;
            while (j <= E && pivot < A[j])
                j--;
            if(i<j)
                swap(A, i, j);
        }
        A[S] = A[j];
        A[j] = pivot;   //피벗을 두 집합을 나눠주는 지점, i와 j가 만나는 지점과 swap
        return j;
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}