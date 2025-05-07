import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) 
                if (computers[i][j] == 1) map[i].add(j);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            que.add(i);
            visit[i] = true;
            answer++;
            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : map[now]) {
                    if (visit[next]) continue;
                    que.add(next);
                    visit[next] = true;
                }
            }
        }
        
        return answer;
    }
}