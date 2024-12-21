import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Integer[] wallets = new Integer[2];
        for (int i = 0; i < 2; i++) {wallets[i] = wallet[i];}
        Integer[] bills = new Integer[2];
        for (int i = 0; i < 2; i++) {bills[i] = bill[i];}
        
        Arrays.sort(wallets, Comparator.reverseOrder());
        
        while (true) {
            Arrays.sort(bills, Comparator.reverseOrder());
            System.out.println(Arrays.toString(wallet) + Arrays.toString(bills));
            if (wallets[0] >= bills[0] && wallets[1] >= bills[1]) {break;}
            bills[0] /= 2;
            System.out.println(Arrays.toString(bills));
            answer++;
        }
        
        return answer;
    }
}