import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> map = new HashMap<>();

        for (String op : operations) {
            String[] str = op.split(" ");
            String p = str[0];
            int num = Integer.parseInt(str[1]);

            if (p.equals("I")) {
                minPQ.add(num);
                maxPQ.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (num == -1) { 
                    while (!minPQ.isEmpty()) {
                        int x = minPQ.poll();
                        if (map.getOrDefault(x, 0) > 0) {
                            map.put(x, map.get(x) - 1);
                            break;
                        }
                    }
                } else { 
                    while (!maxPQ.isEmpty()) {
                        int x = maxPQ.poll();
                        if (map.getOrDefault(x, 0) > 0) {
                            map.put(x, map.get(x) - 1);
                            break;
                        }
                    }
                }
            }
        }

        while (!maxPQ.isEmpty() && map.getOrDefault(maxPQ.peek(), 0) == 0) {
            maxPQ.poll();
        }
        
        while (!minPQ.isEmpty() && map.getOrDefault(minPQ.peek(), 0) == 0) {
            minPQ.poll();
        }

        int max = maxPQ.isEmpty() ? 0 : maxPQ.peek();
        int min = minPQ.isEmpty() ? 0 : minPQ.peek();

        return new int[]{max, min};
    }
}