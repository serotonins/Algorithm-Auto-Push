import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static ArrayList<Way>[] tree;
    static int[][] dr = {{0,-1,0,1}, {1,0,-1,0}};

    static class Way {
        int arr, dis;
        public Way(int arr, int dis) {
            this.arr = arr;
            this.dis = dis;
        }
        public String toString() {return arr+"=>"+dis;}
    }

    static boolean isOut(int y, int x) {return y < 0 || y >= n || x < 0 || x >= m;}



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        ArrayDeque<Way> que = new ArrayDeque<>();
        int tempNode = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int arr = Integer.parseInt(st.nextToken());
            while (arr != -1) {
                Way init = new Way(arr, Integer.parseInt(st.nextToken()));
                if (tempNode == 0) {
                    tempNode = i+1;
                }
                tree[dep].add(init);
                arr = Integer.parseInt(st.nextToken());
            }
        }


        int maxiNode = 0;
        int maxiDis = 0;
        boolean[] visit = new boolean[n+1];
        visit[tempNode] = true;
        que.add(new Way(tempNode, 0));
        while (!que.isEmpty()) {
            Way now = que.poll();
            for (Way next : tree[now.arr]) {
                if (visit[next.arr]) continue;
                visit[next.arr] = true;
                int disSum = now.dis + next.dis;
                que.add(new Way(next.arr, disSum));
                if (disSum > maxiDis) {
                    maxiDis = disSum;
                    maxiNode = next.arr;
                }
            }
        }

        que.add(new Way(maxiNode, 0));
        Arrays.fill(visit, false);
        visit[maxiNode] = true;
        int answer = 0;
        while (!que.isEmpty()) {
            Way now = que.poll();
            for (Way next : tree[now.arr]) {
                if (visit[next.arr]) continue;
                visit[next.arr] = true;
                int disSum = now.dis + next.dis;
                que.add(new Way(next.arr, disSum));
                if (disSum > answer) answer = disSum;
            }
        }

        System.out.println(answer);
    }
}

