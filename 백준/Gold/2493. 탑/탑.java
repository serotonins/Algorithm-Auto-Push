import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int idx = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!que.isEmpty()) {
                if (que.peekFirst()[0] >= num) {
                    break;
                }
                que.pop();
            }
            if (que.size() == 0) {sb.append(0+" ");}
            else {sb.append(que.peekFirst()[1]+" ");}
            que.push(new int[] {num, idx++});
        }

        System.out.println(sb.toString());
    }
}

