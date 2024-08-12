import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String s) {
        String answer = "";
		
		String [] arr = s.split(" ");
		List<Integer> l = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length;i++) {
			l.add(Integer.parseInt(arr[i]));
		}
		
		answer = Collections.min(l) + " " + Collections.max(l);
		return answer;
	}
}