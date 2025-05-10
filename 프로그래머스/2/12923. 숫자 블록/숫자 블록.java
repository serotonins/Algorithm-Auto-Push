import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end-begin+1)];
        for (int i = (int) begin; i < (int) end + 1; i++) {
            int idx = i - (int) begin;
            if (i > 1) answer[idx] = 1;
            for (int j = 2; j < (int) Math.sqrt(i) + 1; j++) {
                if (i % j != 0) continue;
                if (i / j <= 10_000_000) {
                    answer[idx] = i / j;
                    break;
                } else answer[idx] = j;
            }
        }
        return answer;
    }
}