import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int dep, arr, weight;

        public Edge(int dep, int arr, int weight) {
            this.dep = dep;
            this.arr = arr;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {parent[y] =  x;}
        else parent[x] = y;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> que = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            que.add(new Edge(a, b, c));
        }

        while (!que.isEmpty()) {
            Edge now = que.poll();
            if (find(now.arr) == find(now.dep)) continue;
            union(now.arr, now.dep);
            answer += now.weight;
        }

        System.out.println(answer);

    }
}

