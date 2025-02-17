import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char input = 'I', delete = 'D';
    static StringBuilder sb = new StringBuilder();
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            map.clear();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                char inst = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                if (inst == input) {
                    map.compute(num, (key, val) -> {
                        return val == null ? 1 : val+1;
                    });
                } else if (map.size() != 0){
                    map.compute(num == -1 ? map.firstKey() : map.lastKey(), (key, val) -> {
                        if (val == null || val <= 1) return null;
                        return val-1;
                    });
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else {
                sb.append(map.lastKey());
                sb.append(" ");
                sb.append(map.firstKey());
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}

