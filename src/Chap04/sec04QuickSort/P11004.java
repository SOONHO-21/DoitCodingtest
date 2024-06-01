package Chap04.sec04QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004 {
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
        quickSort(A, 0, N - 1,  K - 1);
        System.out.println(A[K - 1]);
    }
    public static void quickSort(int[] A, int S, int E, int K) {
        if(S<E) {
            int pivot = partition(A, S, E);     //피벗의 '인덱스' 구하기
            if (pivot == K)
                return;
            else if (K < pivot)     //K가 피벗의 '인덱스' 보다 작으면
                quickSort(A, S, pivot - 1, K);
            else                    //K가 피벗의 '인덱스' 보다 크거나 같으면
                quickSort(A, pivot + 1, E, K);
        }
    }

    private static int partition(int[] A, int S, int E){    //피벗을 구하는 로직
        if(S+1 == E) {
            if (A[S] > A[E]) swap(A, S, E);
            return E;
        }
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S+1, j = E;
        while (i <= j){
            while (i <= E && pivot > A[i])
                i++;
            while (j > S && pivot < A[j])
                j--;
            if(i < j){
                swap(A, i++, j--);
            }
        }
        A[S] = A[j];
        A[j] = pivot;
        return j;   //피벗의 인덱스 변환
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}