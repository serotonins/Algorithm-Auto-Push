import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            boolean ok = true;

            TreeSet<Integer>[] graph = new TreeSet[v+1];
            for (int i = 0; i < v+1; i++) {
                graph[i] = new TreeSet<>();
            }

            int[] visit = new int[v+1];
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph[y].add(x);
                graph[x].add(y);
            }

            for (int i = 1; i < v + 1 && ok; i++) {
                if (visit[i] != 0) { continue; }
                ArrayDeque<Integer> que = new ArrayDeque<>();
                que.add(i);
                visit[i] = 1;

                while (!que.isEmpty() && ok) {
                    int now = que.poll();
                    for (int next : graph[now]) {
                        if (visit[next] == visit[now]) {
                            ok = false;
                            break;
                        } else if (visit[next] == 0) {
                            visit[next] = visit[now] * (-1);
                            que.add(next);
                        }
                    }
                }
            }

            bw.append(ok ? "YES" : "NO");
            bw.append("\n");
        }

        bw.flush();
        bw.close();

    }
}

