import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
    static int[] arr;

    static boolean ok = true;

    static void dfs(int now, int group) {
        int opp = ~group & 3;
        if (arr[now] == opp || !ok) {
            ok = false;
            return;
        }
        arr[now] = group;
        for (int i : map.get(now)) {
            if (arr[i] == group) {
                ok = false;
                return;
            } else if (arr[i] == 0) dfs(i, opp);
        }
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void mapSetting(int one, int two) {
        if (!map.containsKey(one)) map.put(one, new HashSet<>());
        if (!map.containsKey(two)) map.put(two, new HashSet<>());
        map.get(one).add(two);
        map.get(two).add(one);
    }

    public static void main(String[] args) throws IOException {

        int T = read();

        for (int t = 0; t < T; t++) {
            int v = read();
            int e = read();
            arr = new int[v+1];
            map.clear();
            ok = true;
            for (int i = 0; i < e; i++) {
                mapSetting(read(), read());
            }
            for (int i = 1; i < v+1 && ok; i++) {
                if (arr[i] != 0 || !map.containsKey(i)) continue;
                dfs(i, 1);
            }
            sb.append(ok ? "YES\n" : "NO\n");
        }

        System.out.println(sb.toString());
    }
}

