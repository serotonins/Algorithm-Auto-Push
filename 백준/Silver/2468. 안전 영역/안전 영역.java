import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] region;
	public static int safeMaxi = 1;
	public static int[][] dr = {{0, 1, 0, -1}, {1, 0, -1, 0}};
	public static boolean[][] visit;
	
	public static boolean isin(int[] wv) {
		for (int i = 0; i < 2; i++) {
			if (wv[i] < 0 || wv[i] >= n) return false;
		}
		return true;
	}
	
	public static void bfs(int h) {
		Queue<int[]> que = new LinkedList<int[]>();
		visit = new boolean[n][n];
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (region[i][j] > h && !visit[i][j]) {
					que.add(new int[] {i,j});
					visit[i][j] = true;
					
					while (!que.isEmpty()) {
						int[] now = que.poll();
//						System.out.println("now " + now[0] + " " + now[1]);
						for (int d = 0; d < 4; d++) {
							int y = now[0] + dr[0][d];
							int x = now[1] + dr[1][d];
							if (!isin(new int[] {y,x}) || visit[y][x] || region[y][x] <= h) continue;
							que.add(new int[] {y,x});
							visit[y][x] = true;
						}
					}
//					for (int j2 = 0; j2 < n; j2++) {
//						for (int k = 0; k < n; k++) {
//							System.out.print(visit[j2][k] + "\t");
//						}
//						System.out.println();
//					}
//					
//					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					
					cnt++;
				}
			}
		}
		if (cnt > safeMaxi) safeMaxi = cnt;
//		System.out.println(cnt);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int mini = 101;
		int maxi = 0;
		region = new int[n][n];
		for (int i = 0; i < region.length; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				region[i][j] = Integer.parseInt(s[j]);
				if (maxi < region[i][j]) maxi = region[i][j];
				if (mini > region[i][j]) mini = region[i][j];
			}
		}
		
		
		for (int i = mini; i < maxi; i++) {
//			System.out.println(i + "아이");
			bfs(i);
		}
		
		System.out.println(safeMaxi);
	}
}
