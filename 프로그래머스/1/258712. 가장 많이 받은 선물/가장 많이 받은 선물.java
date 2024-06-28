import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map <String, Map<String, Integer>> giftRecords = new HashMap<String, Map<String,Integer>>();
		Map <String, Integer> giftScore = new HashMap<String, Integer>();
		Map <String, Integer> nextMonthGift = new HashMap<String, Integer>();
		
		for(String friend : friends) {
			giftRecords.put(friend, new HashMap<>());
			giftScore.put(friend, 0);
			nextMonthGift.put(friend,0);
		}
		
		for(String gift : gifts) {
			String [] parts = gift.split(" ");
			String giver = parts[0];
			String receiver = parts[1];
			
			giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver, 0)+1);
			giftScore.put(giver, giftScore.get(giver)+1);
			giftScore.put(receiver, giftScore.get(receiver)-1);
		}
		
		for(String giver : friends) {
			for(String receiver : friends) {
				int giverPoint = giftRecords.get(giver).getOrDefault(receiver, 0);
				int receiverPoint = giftRecords.get(receiver).getOrDefault(giver, 0);
				
				if(giverPoint > receiverPoint) {
					nextMonthGift.put(giver, nextMonthGift.get(giver)+1);
				}else if(giverPoint == receiverPoint && giftScore.get(giver)>giftScore.get(receiver)) {
					nextMonthGift.put(giver, nextMonthGift.get(giver)+1);
				}
			}
		}
        
        return Collections.max(nextMonthGift.values());
    }
}