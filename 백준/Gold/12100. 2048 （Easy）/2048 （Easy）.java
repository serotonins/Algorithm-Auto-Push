import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int maxi = Integer.MIN_VALUE;
	
	public static void Up(int[][] prepan, int cnt) {
		int mystack = 0;
		int mystackY = 0;
		int zero = 0;
		boolean dif = false;
		int[][] pan = new int[n][n];
		for (int i = 0; i < prepan.length; i++) {
			for (int j = 0; j < pan.length; j++) {
				pan[i][j] = prepan[i][j];
			}
		}
		
		for (int i = 0; i < pan.length; i++) {
			zero=0;
			mystack = 0;
			mystackY = 0;
			for (int j = 0; j < pan.length; j++) {
				if (pan[j][i] != 0) {
					if (mystack == pan[j][i]) {
						pan[mystackY][i] = 0;
						pan[j][i] = 0;
						pan[zero-1][i] = mystack * 2;
						mystack = 0;
						dif = true;
						
					} else {
						pan[zero][i] = pan[j][i];
						mystack = pan[j][i];
						if (zero != j) {
							pan[j][i] = 0;
							dif = true;
						}
						mystackY = zero;
						zero++;
					}
				} 
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pan[i][j] > maxi) maxi = pan[i][j];
			}
		}
		
		if (cnt <= 4 && dif) {
			nextG(pan, cnt);
		}
	}
	
	public static void Left(int[][] prepan, int cnt) {
		int mystack = 0;
		int mystackX = 0;
		int zero = 0;
		boolean dif = false;
		int[][] pan = new int[n][n];
		for (int i = 0; i < prepan.length; i++) {
			for (int j = 0; j < pan.length; j++) {
				pan[i][j] = prepan[i][j];
			}
		}
		
		for (int i = 0; i < pan.length; i++) {
			zero=0;
			mystack = 0;
			mystackX = 0;
			for (int j = 0; j < pan.length; j++) {
				if (pan[i][j] != 0) {
					if (mystack == pan[i][j]) {
						pan[i][mystackX] = 0;
						pan[i][j] = 0;
						pan[i][zero-1] = mystack * 2;
						mystack = 0;
						dif = true;
					} else {
						pan[i][zero] = pan[i][j];
						mystack = pan[i][j];
						if (zero != j) {
							pan[i][j] = 0;
							dif = true;
						}
						mystackX = zero;
						zero++;
					}
				} 
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pan[i][j] > maxi) maxi = pan[i][j];
			}
		}
		if (cnt <= 4 && dif) {
			nextG(pan, cnt);
		}
	}
	
	public static void Down(int[][] prepan, int cnt) {
		int mystack = 0;
		int mystackY = 0;
		int zero = n-1;
		boolean dif = false;
		int[][] pan = new int[n][n];
		for (int i = 0; i < prepan.length; i++) {
			for (int j = 0; j < pan.length; j++) {
				pan[i][j] = prepan[i][j];
			}
		}
		
		for (int i = 0; i < pan.length; i++) {
			zero=n-1;
			mystack = 0;
			mystackY = n-1;
			for (int j = n-1; j >= 0; j--) {
				if (pan[j][i] != 0) {
					if (mystack == pan[j][i]) {
						pan[mystackY][i] = 0;
						pan[j][i] = 0;
						pan[zero+1][i] = mystack * 2;
						mystack = 0;
						dif = true;
					} else {
						pan[zero][i] = pan[j][i];
						mystack = pan[j][i];
						if (zero != j) {
							pan[j][i] = 0;
							dif = true;
						}
						mystackY = zero;
						zero--;
					}
				} 
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pan[i][j] > maxi) maxi = pan[i][j];
			}
		}
		
		if (cnt <= 4 && dif) {
			nextG(pan, cnt);
		}
		
	}
	
	public static void Right(int[][] prepan, int cnt) {
		int mystack = 0;
		int mystackX = 0;
		int zero = n-1;
		boolean dif = false;
		int[][] pan = new int[n][n];
		for (int i = 0; i < prepan.length; i++) {
			for (int j = 0; j < pan.length; j++) {
				pan[i][j] = prepan[i][j];
			}
		}
		
		for (int i = 0; i < pan.length; i++) {
			zero=n-1;
			mystack = 0;
			mystackX = n-1;
			for (int j = n-1; j >= 0; j--) {
				if (pan[i][j] != 0) {
					if (mystack == pan[i][j]) {
						pan[i][mystackX] = 0;
						pan[i][j] = 0;
						pan[i][zero+1] = mystack * 2;
						mystack = 0;
						dif = true;
					} else {
						pan[i][zero] = pan[i][j];
						mystack = pan[i][j];
						if (zero != j) {
							pan[i][j] = 0;
							dif = true;
						}
						mystackX = zero;
						zero--;
					}
				} 
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pan[i][j] > maxi) maxi = pan[i][j];
			}
		}
		
		if (cnt <= 4 && dif) {
			nextG(pan, cnt);
		}
	}
	
	public static void nextG(int[][] pan, int cnt) {
		Up(pan, cnt+1);
		Down(pan, cnt+1);
		Left(pan, cnt+1);
		Right(pan, cnt+1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] pan = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Up(pan, 1);
		Down(pan, 1);
		Left(pan, 1);
		Right(pan, 1);
		
		
		System.out.println(maxi);
	}
}
