package Chap06.sec01;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //우선순위 큐(자동 오름차순 정렬)
        for(int i=0; i<N; i++){
            int data = sc.nextInt();
            pq.add(data);
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        while (pq.size() != 1){
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}