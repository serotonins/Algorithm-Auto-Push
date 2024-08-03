import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long maxi = (long) r2 * r2;
        long mini = (long) r1 * r1;
        
        for (int y = 1; y <= r2; y++) {
            long a = (long) Math.floor(Math.sqrt(maxi-(long)y*y));
            long b = (long) Math.ceil(Math.sqrt(mini-(long)y*y));
            if (mini < (long)y*y) b = 0;
            if (b <= a && b >= 0) answer += (long) (a-b+1);
        }
        
        return answer*4;
    }
}