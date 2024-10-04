import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int t = 0; t < n; t++) {
            String[] arr = br.readLine().split(" ");
            String inst = arr[0];
            if (inst.equals("push")) {
                que.add(Integer.parseInt(arr[1]));
            } else if (inst.equals("pop")) {
                if (que.isEmpty()) {
                    bw.append(-1 + "\n");
                } else {
                    bw.append(que.pollFirst() + "\n");
                }
            } else if (inst.equals("size")) {
                bw.append(que.size() + "\n");
            } else if (inst.equals("empty")) {
                bw.append((que.isEmpty() ? 1: 0) + "\n");
            } else {
                if (que.isEmpty()) {
                    bw.append(-1 + "\n");
                } else if (inst.equals("front")) {
                    bw.append(que.peekFirst() + "\n");
                } else if (inst.equals("back")) {
                    bw.append(que.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();

    }
}

