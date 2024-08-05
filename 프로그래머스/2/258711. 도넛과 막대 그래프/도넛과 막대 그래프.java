import java.util.*;

class Solution {
    public int[] solution(int[][] edges) { 
        
        int[] answer = new int[4];
        
        TreeSet<Integer> check = new TreeSet<>();
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        int maxi = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> rm = new HashSet<>();
        for (int[] e: edges) {
            int s = e[0];
            int d = e[1];
            check.add(s);
            check.add(d);
            maxi = Math.max(maxi, s);
            maxi = Math.max(maxi, d);
            if (!map.containsKey(s)) {map.put(s, new TreeSet<>());}
            map.get(s).add(d);
            rm.add(d);
            if (map.get(s).size() >= 2) set.add(s);
        }
        set.removeAll(rm);
        for (int i : set) answer[0] = i;
        check.remove(answer[0]);
        
        int total = map.get(answer[0]).size();
        for (int i : check) {
            switch (map.getOrDefault(i, new TreeSet<>()).size()) {
                case 0: {
                    answer[2]++;
                    break;
                }
                case 2: {
                    answer[3]++;
                }
            }
        }
        answer[1] = total - answer[2] - answer[3];
        
        
        return answer;
    }
}