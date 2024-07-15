import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] answer = new int [id_list.length];
		
		Map<String, List<String> > arr = new HashMap<String, List<String>>();
		List<String> stop_user = new ArrayList<String>();
		
		for(int i =0 ; i<id_list.length;i++) {
			arr.put(id_list[i],new ArrayList<String>());
			answer[i]=0;
		}
		
		for(int i=0; i<report.length;i++) {
			String[] people = report[i].split(" ");
			if(!arr.get(people[1]).contains(people[0])) {
				arr.get(people[1]).add(people[0]);
			}
			if(arr.get(people[1]).size()>=k&&!stop_user.contains(people[1])) {
				stop_user.add(people[1]);
			}
		}
		
		for(int i =0; i<stop_user.size();i++) {
			int arrSize= arr.get(stop_user.get(i)).size();
			for(int j=0; j<arrSize;j++) {
				for(int h=0; h<id_list.length;h++) {
					if(arr.get(stop_user.get(i)).get(j).equals(id_list[h])) {
						answer[h]++;
					}
				}
			}
		}
        
        return answer;
    }
}