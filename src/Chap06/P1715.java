package Chap06;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            pq.add(temp);
        }
        int sum = 0;
        while (!pq.isEmpty()){
            int data1 = pq.remove();
            int data2 = pq.remove();
            sum += (data1 + data2);
            pq.add(sum);
        }
        System.out.println(sum);
    }
}