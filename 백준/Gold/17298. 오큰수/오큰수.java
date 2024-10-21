import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.isEmpty() && arr[stack.peekFirst()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }

            stack.push(i);
        }
        while (!stack.isEmpty()) answer[stack.pop()] = -1;

        for (int i = 0; i < n; i++) {
            bw.append(answer[i] + " ");
        }

        bw.flush();
        bw.close();

    }
}

