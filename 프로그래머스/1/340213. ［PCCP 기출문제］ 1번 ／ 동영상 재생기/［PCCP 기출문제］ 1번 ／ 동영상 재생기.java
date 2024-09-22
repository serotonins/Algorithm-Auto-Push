import java.util.*;

class Solution {
    
    public int str2int(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3, 5));
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int time = str2int(pos);
        int endTime = str2int(video_len);
        int ops = str2int(op_start);
        int ope = str2int(op_end);
        
        for (String inst : commands) {
            if (time >= ops && time < ope) time = ope;
            if (inst.equals("prev")) {
                time = Math.max(0, time-10);
            } else if (inst.equals("next")) {
                time = Math.min(endTime, time+10);
            }
        }
        if (time >= ops && time < ope) time = ope;
        
        String min = (time / 60 > 9 ? time / 60 : "0"+time / 60) + ":";
        min += time%60 > 9 ? time%60 : "0"+time%60;
        return min;
    }
}