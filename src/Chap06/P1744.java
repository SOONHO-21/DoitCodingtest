package Chap06;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plustPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            if(temp == 1)
                one++;
            else if(temp < 0)
                minusPq.add(temp);
            else if(temp > 1)
                plustPq.add(temp);
            else
                zero++;
        }
        int sum = 0;
        //양수 처리
        while (plustPq.size() > 1){
            int data1 = plustPq.remove();
            int data2 = plustPq.remove();
            sum += data1 * data2;
        }
        if(plustPq.isEmpty())
            sum += plustPq.remove();
        //음수 처리
        while (minusPq.size() > 1){
            int data1 = plustPq.remove();
            int data2 = plustPq.remove();
            sum += data1 * data2;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0)
                sum += minusPq.remove();
        }
        //1 처리
        sum += one;
        System.out.println(sum);
    }
}