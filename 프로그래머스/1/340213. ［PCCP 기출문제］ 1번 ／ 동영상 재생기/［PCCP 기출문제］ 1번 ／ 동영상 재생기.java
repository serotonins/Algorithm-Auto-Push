import java.util.*;

class Solution {
    int len, start, end;
    int parseString2Int(String str) {
        int m = Integer.parseInt(str.substring(0,2));
        int s = Integer.parseInt(str.substring(3,5));
        return m * 60 + s;
    }
    String parseInt2String(int time) {
        int m = time / 60;
        int s = time % 60;
        return String.format("%02d:%02d", m, s);
    }
    int skipOpening(int time) {
        return time <= end && time >= start ? end : time;
    }
    int next(int time) {
        return time = Math.min(time+10, len);
    }
    int prev(int time) {
        return Math.max(0, time - 10);
    }
    int process(String inst, int time) {
        if (inst.equals("next")) return next(time);
        else return prev(time);
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        len = parseString2Int(video_len);
        start = parseString2Int(op_start);
        end = parseString2Int(op_end);
        int pt = parseString2Int(pos);
        pt = skipOpening(pt);
        
        for (String inst: commands) {
            pt = skipOpening(process(inst, pt));
        }
        
        return parseInt2String(pt);
    }
}