import java.util.*;

class Solution {
    boolean check(String s) {
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') cnt++;
            else if (cnt <= 0) return false;
        }
        return true;
    }
    int find(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;
            
            if (cnt == 0) {
                return i + 1;
            }
        }
        return s.length();
    }
    String rec(String s) {
        if (s.length() == 0) return s;
        
        int ui = find(s);
        
        String u = s.substring(0, ui);
        String v = s.substring(ui, s.length());
        
        if (check(u)) return u + rec(v);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(rec(v));
            sb.append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }
    }
    public String solution(String p) {
        return rec(p);
    }
}