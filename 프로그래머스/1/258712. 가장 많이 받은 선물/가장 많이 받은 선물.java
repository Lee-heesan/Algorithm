import java.util.HashMap;
import java.util.Map;


class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer=0;
		
		Map<String , Integer> index = new HashMap<String, Integer>();
		Map<String,Map<String, Integer>> records = new HashMap<String, Map<String,Integer>>();
		int [] score = new int[friends.length];
		int [] nextGift = new int[friends.length];
		
		for(int i = 0; i<friends.length;i++) {
			records.put(friends[i] ,new HashMap<>());
			index.put(friends[i], i);
		}
		
		for(String gift : gifts) {
			String [] person =  gift.split(" ");
			String giver = person[0];
			String receiver = person[1];
			
			records.get(giver).put(receiver, records.get(giver).getOrDefault(receiver, 0)+1);
			score[index.get(giver)]++;
			score[index.get(receiver)]--;
		}
		
		
		for(String giver : friends) {
			for(String receiver : friends) {
				int giverToReceiver = records.get(giver).getOrDefault(receiver, 0);
				int receiverToGiver = records.get(receiver).getOrDefault(giver, 0);

				
				if(giverToReceiver>receiverToGiver) {
					nextGift[index.get(giver)]++;
				}else if (giverToReceiver == receiverToGiver && score[index.get(giver)]>score[index.get(receiver)]) {
					nextGift[index.get(giver)]++;
				}
			}
		}
			
		for(int i : nextGift) {
			answer = Math.max(i, answer);
		}
        
        return answer;
    }
}