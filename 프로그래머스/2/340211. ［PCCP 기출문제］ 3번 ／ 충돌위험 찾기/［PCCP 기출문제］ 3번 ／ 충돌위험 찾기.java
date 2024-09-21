import java.util.*;

class Solution {
    static int[][] dr = {{1,-1,0,0}, {0,0,-1,1}};
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        for (int i = 0; i < points.length; i++) {points[i][0]--; points[i][1]--;}
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[0].length; j++) {
                routes[i][j]--;
            }
        }
        int[] arr = new int[100];
        for (int i = 0; i < routes.length; i++) {arr[routes[i][0]]++; if (arr[routes[i][0]]==2) answer++;}
        
        int[] out = new int[routes.length];
        int[][] map;
        int[][] robots = new int[routes.length][2];
        for (int i = 0; i < routes.length; i++) {
            robots[i][0] = points[routes[i][0]][0];
            robots[i][1] = points[routes[i][0]][1];
        }
        
        int outcnt = 0;
        while (outcnt < routes.length) {
            map = new int[100][100];
            
            for (int i = 0; i < robots.length; i++) {
                if (out[i] == routes[0].length-1) {continue;}
                
                int[] goal = points[routes[i][out[i]+1]];
                
                if (robots[i][0] != goal[0]) {
                    if (robots[i][0] < goal[0]) {robots[i][0]++;}
                    else {robots[i][0]--;}
                } else {
                    if (robots[i][1] < goal[1]) {robots[i][1]++;}
                    else {robots[i][1]--;}
                }
                
                map[robots[i][0]][robots[i][1]]++;
                
                if (map[robots[i][0]][robots[i][1]] == 2) answer++;
                
                if (isSame(robots[i], goal)) {
                    out[i]++;
                    if (out[i] == routes[0].length-1) outcnt++;
                }
            }
            
            
        }
        
        return answer;
    }
    
    public boolean isOut(int y, int x) {
        return y < 0 || x < 0;
    }
    
    public boolean isSame(int[] one, int[] two) {
        return one[0] == two[0] && one[1] == two[1];
    }
}