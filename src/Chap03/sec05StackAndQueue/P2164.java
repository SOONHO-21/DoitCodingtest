package Chap03.sec05StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //카드의 개수

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<N+1; i++)
            queue.add(i);

        while (queue.size() > 1){
            queue.poll();       //맨 위에 카드 꺼내기(버림)
            queue.add(queue.poll());    //맨 위의 카드를 "뺀 것"을 가장 카드 아래로 이동
        }
        System.out.println(queue.poll());
    }
}