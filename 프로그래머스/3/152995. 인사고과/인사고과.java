import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        int[] wan = {scores[0][0], scores[0][1]};
        Arrays.sort(scores, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        
        int[] fir = {-1, -1}; // 0 번 값이 더 큰 걸 보장.
        int[] sec = {-1, -1}; // 같은 층일 수 있음. 가장 맥시한 값.
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < scores.length; i++) {
            int[] now = scores[i];
            
            boolean pass = false;
            if (sec[0] != now[0]) { 
                fir[0] = sec[0];
                fir[1] = sec[1];
                if (sec[1] > now[1]) pass = true;
                else if (sec[1] < now[1]) {
                    sec[0] = now[0];
                    sec[1] = now[1];
                }
            } else {
                if (sec[1] < now[1]) sec[1] = now[1];
                else if (fir[1] > now[1]) pass = true;
            }
            
            
            if (wan[0] == now[0] && wan[1] == now[1] && pass) {
                return -1;
            }
            if (!pass) {
                int summ = now[0]+now[1];
                map.put(summ, map.getOrDefault(summ, 0)+1);
            }
        }
        
        int rank = 1;
        int wansum = wan[0] + wan[1];
        for (int i : map.keySet()) {
            if (i == wansum) { return rank;}
            rank += map.get(i);
        }
        
        return answer;
    }
}