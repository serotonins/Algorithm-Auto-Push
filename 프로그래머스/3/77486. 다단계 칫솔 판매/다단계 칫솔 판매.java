import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, Integer> sellerIndexMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            sellerIndexMap.put(enroll[i], i);
        }
        
        Map<Integer, Integer> referMap = new HashMap<>();
        for (int i = 0; i < referral.length; i++) {
            if (!referral[i].equals("-")) referMap.put(i, sellerIndexMap.get(referral[i]));
        }
        
        
        for (int i = 0; i < seller.length; i++) {
            int s = sellerIndexMap.get(seller[i]);
            int a = amount[i]*100;
            int r = referMap.getOrDefault(s, -1);
            answer[s] += (a - a/10);
            while (r != -1) {
                s = r;
                r = referMap.getOrDefault(r, -1);
                if (a == a/10) break;
                a /= 10;
                answer[s] += (a - a/10);
            }
            
        }
        return answer;
    }
}