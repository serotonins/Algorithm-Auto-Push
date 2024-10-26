import java.util.*;

class Solution {
    static class WV {
        int y, x;
        public WV(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    static boolean isOut(int y, int x, int n, int m) {return y < 0 || y >= n || x < 0 || x >= m;}
    public int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < maps[0].length(); x++) {
                int sum = 0;
                if (visit[y][x] || maps[y].charAt(x) == 'X') {continue;}
                ArrayDeque<WV> que = new ArrayDeque<>();
                que.add(new WV(y,x));
                visit[y][x] = true;
                while (!que.isEmpty()) {
                    WV now = que.poll();
                    sum += Integer.parseInt(maps[now.y].charAt(now.x)+"");
                    for (int i = 0; i < 4; i++) {
                        int w = now.y + dr[0][i];
                        int v = now.x + dr[1][i];
                        if (isOut(w,v,maps.length,maps[0].length()) || maps[w].charAt(v) == 'X' || visit[w][v]) {continue;}
                        visit[w][v] = true;
                        que.add(new WV(w,v));
                    }
                }
                list.add(sum);
            }
        }
        
        int[] answer;
        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            int idx = 0;
            for (int i : list) {answer[idx++] = i;}
            Arrays.sort(answer);
        }
        
        return answer;
    }
}