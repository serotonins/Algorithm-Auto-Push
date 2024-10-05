import java.util.*;

class Solution {
    class Work {
        String name;
        int last, time;
        public Work(String name, int last, int time) {
            this.name = name;
            this.last = last;
            this.time = time;
        }
        public String toString() {
            return "[" + name + " " + last + "]";
        }
    }
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int index = 0;
        
        TreeMap<Integer, Work> wait = new TreeMap<>();
        ArrayDeque<Work> keep = new ArrayDeque<>();
        // TreeMap<Integer, Work> keep = new TreeMap<>(new Comparator<>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o2 - o1;
        //     }
        // });
        
        for (String[] s : plans) {
            int time = Integer.parseInt(s[1].substring(0, 2));
            int minute = Integer.parseInt(s[1].substring(3, 5));
            
            wait.put(time*60+minute, new Work(s[0], Integer.parseInt(s[2]), time*60+minute));
        }
        
        int time = 0;
        Work pre = null;
        int p = 0;
        while (p < n) {
            
            if (wait.size() > 0) {
                // 새 거 꺼내
                // 기존에 하던 게 없으면 그냥 넘어가고
                // 새 거보다 원래 하던 게 시간이 작으면 answer에 넣어주고 멈춰둔 일 이어하기
                // 같으면 answer에 넣기만 하기
                // 시간이 크면 킵에 넣는데 진행한 시간만큼 빼주고 스택에 넣기
                time = wait.firstKey();
                Work now = wait.get(time);
                wait.remove(time);
                if (pre == null) {} // 하던 일이 없을 때
                else if (time < pre.time+pre.last) { // 하던 일 도중에 새 거 시작해야 할 때
                    keep.add(new Work(pre.name, pre.last-(time-pre.time), time));
                } else if (time == pre.time+pre.last) { // 하던 일이 끝나자 마자 새 거 시작
                    answer[p++] = pre.name;
                } else { // 일 하고 시간 남을 때
                    answer[p++] = pre.name;
                    if (keep.size() > 0) {
                        Work side = null;
                        int t = pre.time+pre.last; // 일 마친 시간
                        while (keep.size()>0) {
                            side = keep.pollLast();
                            if (t + side.last > time) { // 다 못 끝내고 턴 넘겨주면
                                keep.add(new Work(side.name, side.last-(time-t), t));
                                break;
                            } else if (t + side.last == time) { // 딱 끝낼 수 있을 때
                                answer[p++] = side.name;
                                break;
                            } else { // 다 하고도 시간 남을 때
                                answer[p++] = side.name;
                                t += side.last;
                            }
                        }
                    }
                }
                now.time = time;
                pre = now;
            } else {
                if (pre != null) {
                    answer[p++] = pre.name;
                    pre = null;
                    continue;
                }
                if (keep.size()==0) {break;}
                Work now = keep.pollLast();
                answer[p++] = now.name;
            }
        }
        
        return answer;
    }
}