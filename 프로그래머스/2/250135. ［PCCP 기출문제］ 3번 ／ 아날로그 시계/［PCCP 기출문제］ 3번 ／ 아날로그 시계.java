import java.util.*;

class Solution {
    int whatTimeIsIt(int h, int m, int s) { return h*3600 + m*60 + s; }
    
    int secondDegree(int s) { return 1000 * s * 360 / 60; }
    int minuteDegree(int m, int s) { return 1000 * m * 360 / 60 + secondDegree(s) / 60; }
    int hourDegree(int h, int m, int s) { return 1000 * (h%12) * 360 / 12 + minuteDegree(m, s) / 12; }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int startTime = whatTimeIsIt(h1, m1, s1);
        int endTime = whatTimeIsIt(h2, m2, s2);
        
        boolean sm = secondDegree(s1) <= minuteDegree(m1, s1);
        boolean sh = secondDegree(s1) <= hourDegree(h1, m1, s1);
        boolean mh = minuteDegree(m1, s1) <= hourDegree(h1, m1, s1);
        
        int t = 0;
        
        while (whatTimeIsIt(h1, m1, s1) != whatTimeIsIt(h2, m2, s2)) {
            s1++;
            if (s1 == 60) { m1++; s1 = 0; }
            if (m1 == 60) { h1++; m1 = 0; }
            int temp = 0;
            
            int sd = secondDegree(s1);
            int md = minuteDegree(m1, s1);
            int hd = hourDegree(h1, m1, s1);
            
            if (sm && (sd > md || sd == 0 && md > (360-6) * 1000)) {
                temp++;
            }
            if (sh && (sd > hd || sd == 0 && hd > (360-6) * 1000)) {
                temp++;
            }
            if (temp == 2 && mh && (md > hd || md == 0 && hd > 360-6)) {
                temp--;
            }
            
            sm = sd <= md;
            sh = sd <= hd;
            mh = md <= hd;
            
            answer += temp;
        }
        
        if (secondDegree(s2) == minuteDegree(m2, s2) || secondDegree(s2) == hourDegree(h2, m2, s2)) answer++;
        
        return answer;
    }
}