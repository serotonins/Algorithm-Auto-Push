import java.util.*;

class Solution {
    int timeToInt(String str) {
        int h = Integer.parseInt(str.substring(0, 2)) * 60 * 60;
        int m = Integer.parseInt(str.substring(3, 5)) * 60;
        int s = Integer.parseInt(str.substring(6, 8));
        return h + m + s;
    }
    
    String intToTime(int time) {
        StringBuilder answer = new StringBuilder();
        answer.append(((time / 3600 < 10) ? "0" : "") + (time / 3600)).append(":");
        answer.append(((time % 3600 / 60 < 10) ? "0" : "") + (time % 3600 / 60)).append(":");
        answer.append(((time % 60 < 10) ? "0" : "") + (time % 60));
        return answer.toString();
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int playLen = timeToInt(play_time);
        int[] timeline = new int[playLen + 2];
        
        for (String log : logs) {
            timeline[timeToInt(log.substring(0, 8))]++;
            timeline[timeToInt(log.substring(9, 17))]--;
        }
        
        for (int i = 1; i <= playLen; i++) {
            timeline[i] += timeline[i-1];
        }
        
        int advLen = timeToInt(adv_time);
        
        long acc = 0;
        for (int i = 0; i < advLen; i++) {
            acc += timeline[i];
        }
        
        long maxi = acc;
        int time = 0;
        for (int i = 1; i <= playLen - advLen; i++) {
            acc += timeline[i + advLen - 1] - timeline[i - 1];
            if (acc > maxi) {
                maxi = acc;
                time = i;
            }
        }
        
        return intToTime(time);
    }
}