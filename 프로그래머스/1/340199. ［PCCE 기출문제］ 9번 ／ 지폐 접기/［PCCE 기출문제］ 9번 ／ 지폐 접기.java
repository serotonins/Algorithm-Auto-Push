import java.util.*;

class Solution {
    public int min(int[] arr) {return Math.min(arr[0], arr[1]);}
    public int max(int[] arr) {return Math.max(arr[0], arr[1]);}
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if (max(wallet) >= max(bill) && min(wallet) >= min(bill)) {break;}
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }
        return answer;
    }
}