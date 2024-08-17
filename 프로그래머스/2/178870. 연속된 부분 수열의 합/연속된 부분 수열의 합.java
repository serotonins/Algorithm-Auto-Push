import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int[] partial = new int[sequence.length];
        partial[0] = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            partial[i] = partial[i-1] + sequence[i];
        }
        
        int s = -1;
        int e = 0;
        int min = sequence.length+1;
        while (s < e && e < sequence.length) {
            int minus = s == -1 ? 0 : partial[s];
            int now = partial[e] - minus;
            if (now == k) {
                if (min > e-s) {
                    min = e-s;
                    answer[0] = s+1;
                    answer[1] = e;
                }
                e++;
            } else if (now < k) {
                e++;
            } else {
                s++;
            }
        }
        
        return answer;
    }
}