import java.io.*;
import java.util.*;

public class Main { 
	
	static int n, m, result;

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		
		int[] sosu = new int[100001]; 
		Set<Integer> set = new HashSet<>();

		
		result = 0;
		
		for (int i = 2; i < 100001; i++) { // 소수인지 아닌지가 아니라 몇번 나누어졌는지도 세야해서 제곱근이 아니라 전체 다를 범위로
			if (sosu[i] == 0) {
				for (int j = i+i; j < 100001; j+=i) {
					int imsi = j;
					while (imsi % i == 0) {
						sosu[j]++;
						imsi /= i;
					}
				}
			}
		}

		
		for (int i = 2; i <= m; i++) {
			if (sosu[i] == 0) set.add(i);
		}
		
		for (int i = n; i <= m; i++) {
			if (set.contains(sosu[i])) result++;
		}
		
		System.out.println(result);
	}
}
