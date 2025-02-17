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
                if (st.nextToken().charAt(0) == input) {
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0)+1);
                } else if (map.size() != 0){
                    int num = Integer.parseInt(st.nextToken());
                    if (num == -1) num = map.firstKey();
                    else num = map.lastKey();
                    if (map.get(num) == 1) map.remove(num);
                    else map.put(num, map.get(num)-1);
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

