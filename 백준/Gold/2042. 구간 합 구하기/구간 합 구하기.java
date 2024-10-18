import java.util.*;
import java.io.*;

public class Main {

    static long[] arr, tree;

    static long segment(int start, int end, int node) {
        if (start == end) { return tree[node] = arr[start]; } // 단일 노드
        int mid = (start + end) / 2;
        return tree[node] = segment(start, mid, node*2) + segment(mid+1, end, node*2+1);
    }

    static long sum(int start, int end, int node, int left, int right) { // start, end는 보는 tree 윈도우의 범위를 나타냄
        if (left > end || right < start) return 0; // 구하고 싶은 범위가 이 tree 구간 밖
        if (left <= start && right >= end) return tree[node]; // 이 tree 구간이 구하고 싶은 범위 안에 포함됨
        // 이 tree 구간에 포함된 것을 일부는 포함하고 일부는 안 포함한 구간 합을 원할 때는 아래
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long diff) { // index = 바꾼 노드 인덱스
        if (index < start || index > end) return; // 변경한 node의 인덱스가 tree 구간 밖에 있는 경우
        tree[node] += diff; // 원래값보다 변경된 차이 반영
        if (start == end) return; // 단일 노드(마지막 자손)면 여기서 끝. 아니면 아래까지 변경해나가기
        int mid = (start + end) / 2;
        update(start, mid, node*2, index, diff);
        update(mid+1, end, node*2+1, index, diff);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n*4];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        segment(0, n-1, 1);

//        System.out.println(Arrays.toString(tree));

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());
            if (inst == 2) {
                b--;
                bw.append(sum(0, n-1, 1, a, (int) b) + "\n");
            } else {
                update(0, n-1, 1, a, b-arr[a]);
                arr[a] = b;
            }
        }

        bw.flush();
        bw.close();

    }
}

