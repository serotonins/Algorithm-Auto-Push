class Solution {
    public int solution(int[] a) {
        int inf = Integer.MAX_VALUE;
        // 양쪽에 나보다 작은 게 있으면 실패
        int alen = a.length;
        int answer = alen;
        int[] minisFront = new int[alen];
        int[] minisBehind = new int[alen];
        minisFront[0] = inf;
        minisBehind[alen-1] = inf;
        for (int i = 1; i < alen; i++) {
            minisFront[i] = Math.min(minisFront[i-1], a[i-1]);
            minisBehind[alen-1-i] = Math.min(minisBehind[alen-i], a[alen-i]);
        }
        for (int i = 0; i < alen; i++) {
            if (a[i] > minisFront[i] && a[i] > minisBehind[i]) answer--;
        }
        return answer;
    }
}