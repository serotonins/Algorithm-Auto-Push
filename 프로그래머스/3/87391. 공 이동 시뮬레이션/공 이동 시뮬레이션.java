import java.util.*;

class Solution {
    
    static int n, m;
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        Solution.n = n;
        Solution.m = m;
        
        long left = y, right = y;
        long up = x, down = x;
        
        for (int q = queries.length - 1; q >= 0; q--) {
            int[] query = queries[q];
            int command = query[0];
            int dx = query[1];
            
            switch (command) {
                case 0:
                    if (left == 0) {
                        right = Math.min(m - 1, right + dx);
                    } else {
                        left = Math.max(0, left + dx);
                        right = Math.min(m - 1, right + dx);
                    }
                    break;
                case 1:
                    if (right == m - 1) {
                        left = Math.max(0, left - dx);
                    } else {
                        right = Math.min(m - 1, right - dx);
                        left = Math.max(0, left - dx);
                    }
                    break;
                case 2:
                    if (up == 0) {
                        down = Math.min(n - 1, down + dx);
                    } else {
                        up = Math.max(0, up + dx);
                        down = Math.min(n - 1, down + dx);
                    }
                    break;
                case 3:
                    if (down == n - 1) {
                        up = Math.max(0, up - dx);
                    } else {
                        down = Math.min(n - 1, down - dx);
                        up = Math.max(0, up - dx);
                    }
                    break;
            }
            
            if (right < 0 || left >= m || down < 0 || up >= n) return 0;
        }
        
        long answer = (right - left + 1) * (down - up + 1);
        return answer;
    }
}
