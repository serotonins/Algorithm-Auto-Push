import java.util.function.Function;
import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>();
    class SB {
        int s, b;
        public SB(String score) {
            this.s = Integer.parseInt(score.substring(0,1));
            this.b = Integer.parseInt(score.substring(3,4));
        }
        public SB(int s, int b) {
            this.s = s;
            this.b = b;
        }
        boolean same(SB o) {
            return this.s == o.s && this.b == o.b;
        }
        @Override
        public int hashCode() {
            return s * 10 + b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SB)) return false;
            SB other = (SB) o;
            return this.s == other.s && this.b == other.b;
        }
    }
    
    public int solution(int n, Function<Integer, String> submit) {
        init();
        
        String score = submit.apply(1234);
        if (score.equals("4S 0B")) return 1234;
        semiSupply(1234, score);
        while (--n > 0) {
            int num = guess();
            score = submit.apply(num);
            if (score.equals("4S 0B")) return num;
            semiSupply(num, score);
        }
        return guess();
    }
    void init() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i==j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (i==k || j==k) continue;
                    for (int l = 1; l <= 9; l++) {
                        if (i==l || j==l || k==l) continue;
                        candidates.add(i*1000+j*100+k*10+l);
                    }
                }
            }
        }
    }
    SB calSB(int ori, int gin) {
        SB sb = new SB(0, 0);
        for (int i = 0; i < 4; i++) {
            int c = ori % (int) Math.pow(10, 4-i) / (int) Math.pow(10, 3-i);
            for (int j = 0; j < 4; j++) {
                int n = gin % (int) Math.pow(10, 4-j) / (int) Math.pow(10, 3-j);
                if (c==n) {
                    if (i==j) sb.s++;
                    else sb.b++;
                }
            }
        }
        return sb;
    }
    void semiSupply(int num, String score) {
        SB numSB = new SB(score);
        
        Set<Integer> temp = new HashSet<>();
        for (int can : candidates) {
            SB candiSB = calSB(can, num);
            if (numSB.same(candiSB)) temp.add(can);
        }
        candidates.clear();
        candidates.addAll(temp);
    }
    int guess() {
        int mini = Integer.MAX_VALUE;
        int miniCan = 0;
        for (int can: candidates) {
            Map<SB, Integer> map = new HashMap<>();
            int maxi = 0;
            for (int das: candidates) {
                if (can == das) continue;
                SB sb = calSB(can, das);
                map.put(sb, map.getOrDefault(sb, 0)+1);
            }
            for (SB sb : map.keySet()) {
                maxi = Math.max(maxi, map.get(sb));
            }
            if (mini > maxi) {
                mini = maxi;
                miniCan = can;
            }
        }
        return miniCan;
    }
}