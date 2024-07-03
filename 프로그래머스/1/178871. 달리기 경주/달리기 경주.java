import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = playerIndexMap.get(calling);
            if (idx > 0) { 
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;
                
                playerIndexMap.put(players[idx - 1], idx - 1);
                playerIndexMap.put(players[idx], idx);
            }
        }
        
        return players;
    }
}
