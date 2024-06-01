package Chap03.sec04SlidingWindow;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> myDeque = new LinkedList<>();    //덱은 연결리스트 자료구조

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!myDeque.isEmpty() && myDeque.getLast().value < now){
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now ,i));
            //범위에서 벗어나는 인덱스의 요소 제거
            if(myDeque.getFirst().index <= i-L){
                myDeque.removeFirst();
            }

            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node { //스태틱 이너 클래스(객체 생성 필요 없이 그냥 사용 가능)
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}