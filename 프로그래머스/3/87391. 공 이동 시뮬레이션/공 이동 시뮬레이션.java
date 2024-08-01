import java.util.*;

class Solution {
    
    static int n, m;
    class Ball implements Comparable<Ball> {
        int y, x, t;
        public Ball(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
        public int compareTo(Ball o) {
            return o.t - this.t;
        }
        public String toString() { return y + " " + x + " " + t; }
    }
    
    public boolean isOut(int y, int x) { return y < 0 || y >= n || x < 0 || x >= m; }
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        Solution.n = n;
        Solution.m = m;
        Set<String> set = new HashSet<>();
        Map<String, Integer> visit = new HashMap<>();
        
        ArrayDeque<Ball> que = new ArrayDeque<>();
        que.add(new Ball(x,y,queries.length-1));
        
        while (!que.isEmpty()) {
            Ball now = que.pollFirst();
            sb = new StringBuilder();
            sb.append(now.y);
            sb.append(' ');
            sb.append(now.x);
            
            if (now.t == -1) {
                set.add(sb.toString());
                continue;
            }
            
            if (visit.getOrDefault(sb.toString(), Integer.MAX_VALUE) == now.t) continue;
            visit.put(sb.toString(), now.t);
            
            int[] query = queries[now.t];
            int command = query[0];
            int dx = query[1];
            
            int[] dr = {0, 0};
            if (command == 0) dr[1]++;
            else if (command == 1) dr[1]--;
            else if (command == 2) dr[0]++;
            else dr[0]--;
            int goY = now.y;
            int goX = now.x;
            int outY = now.y - dr[0];
            int outX = now.x - dr[1];
            
            if (isOut(outY, outX)) {
                que.add(new Ball(now.y, now.x, now.t-1));
            }
            for (int i = 0; i < dx-1; i++) {
                goY += dr[0];
                goX += dr[1];
                if (isOut(goY, goX) || !isOut(outY, outX)) break;
                
                que.add(new Ball(goY, goX, now.t-1));
            }
            goY += dr[0];
            goX += dr[1];
            if (!isOut(goY, goX)) {
                que.add(new Ball(goY, goX, now.t-1));
            }
        }
        
        return set.size();
    }
}