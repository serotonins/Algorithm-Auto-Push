import java.util.*;

class Solution {
    boolean[] stVisit; // 홀짝트리 가능
    boolean[] reVisit; // 역트리 가능
    
    int maxi = 0;
    static int[] nodes;
    Map<Integer, List<Integer>> tree = new HashMap<>();
    
    boolean isOdd(int num) {return num % 2 == 1;}
    
    void start() {
        for (int root: nodes) {
            if (!tree.containsKey(root)) { // 단일 노드 트리 처리
                if (isOdd(root)) reVisit[root] = true;
                else stVisit[root] = true;
                continue;
            }            
            
            boolean re = isOdd(root) ^ isOdd(tree.get(root).size());
            boolean[] visit = re ? reVisit : stVisit;
            if (visit[parents[root]]) continue;
            
            boolean ok = true;
            for (int child: tree.get(root)) {
                ok &= move(child, root, re);
                if (!ok) break;
            }
            
            if (ok) visit[parents[root]] = true;
        }
    }
    boolean move(int num, int parent, boolean re) {
        boolean meSt = isOdd(num) ^ isOdd(tree.get(num).size());
        if (meSt ^ re) {
            boolean ok = true;
            for (int child: tree.get(num)) {
                if (child == parent) continue;
                ok &= move(child, num, re);
                if (!ok) return false;
            }
            return true;
        } else { // 부모 상태와 다르면
            return false;
        }
    }
    
    int[] parents;
    
    void union(int y, int x) {
        y = find(y);
        x = find(x);
        if (y < x) parents[x] = y;
        else parents[y] = x;
    }
    int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        Solution.nodes = nodes;
        Arrays.sort(nodes);
        int[] answer = new int[2];
        for (int i : nodes) {maxi = Math.max(maxi, i);}
        parents = new int[maxi+1];
        for (int i = 0; i <= maxi; i++) {parents[i]=i;}
        stVisit = new boolean[maxi+1];
        reVisit = new boolean[maxi+1];
        
        for (int[] edge: edges) {
            if (!tree.containsKey(edge[0])) tree.put(edge[0], new ArrayList<>());
            if (!tree.containsKey(edge[1])) tree.put(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
            union(edge[0], edge[1]);
        }
        
        start();
        for (int num: nodes) {
            if (stVisit[parents[num]]) {
                answer[0]++;
                stVisit[parents[num]] = false;
            }
            if (reVisit[parents[num]]) {
                answer[1]++;
                reVisit[parents[num]] = false;
            }
            // System.out.println(num + " " + Arrays.toString(answer));
        }
        return answer;
    }
}