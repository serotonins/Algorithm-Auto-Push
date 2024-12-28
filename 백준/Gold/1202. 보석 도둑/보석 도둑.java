import java.util.*;
import java.io.*;

public class Main {

    static class Jewel implements Comparable<Jewel> {
        int w, v;
        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
        public int compareTo(Jewel o) {
            if (this.v == o.v) return this.w - o.w; // 가치가 같다면 더 가벼운 순
            return o.v - this.v; // 가치가 더 나가는 순
        }
    }

    static int n, k, inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> store = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.w == o2.w) return o2.v - o1.v;
                return o1.w - o2.w; // 가벼운 것부터 나열
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            store.add(new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Integer[] bag = new Integer[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        long answer = 0;
        PriorityQueue<Jewel> que = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        for (int i = 0; i < k; i++) {
            while (!store.isEmpty()) {
                if (store.peek().w > bag[i]) {break;}
                que.add(store.poll());
            } // 지금 가방에 들어갈 수 있는 보석 중 가장 비싼 것
            if (!que.isEmpty()) {
                answer += que.poll().v;
            }
        }
        System.out.println(answer);
    }
}

