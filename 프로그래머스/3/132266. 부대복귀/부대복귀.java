import java.util.*;

class Solution {
    class WV {
        int r, cnt;
        public WV(int r, int cnt) {
            this.r = r;
            this.cnt = cnt;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        ArrayList<Integer>[] map = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            map[road[0]].add(road[1]);
            map[road[1]].add(road[0]);
        }
        
        PriorityQueue<WV> que = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        int[] visit = new int[n+1];
        Arrays.fill(visit, -1);
        visit[destination] = 0;
        que.add(new WV(destination, 0));
        while (!que.isEmpty()) {
            WV now = que.poll();
            for (int i : map[now.r]) {
                if (visit[i] != -1) continue;
                visit[i] = now.cnt+1;
                que.add(new WV(i, now.cnt+1));
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visit[sources[i]];
        }
        
        return answer;
    }
}