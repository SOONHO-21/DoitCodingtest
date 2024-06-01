package Chap05.sec02BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1)); //A[][] 초기화
            }
        }
        BFS(0, 0);  //(0,0)부터 탐색 시작
        System.out.println(A[N-1][M-1]);
    }
    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});  //좌표값(좌표에 해당하는 A[][]의 값이 아니다) 저장
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < M) {    //좌표가 유효한지 확인
                    if(A[x][y] >= 1 && !visited[x][y]) {    //방문 가능한지 확인
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});    //여기에 저장되는건 좌표다
                                                        // 좌표의 깊이 값이 아니다.
                    }
                }
            }
        }
    }
}