import java.util.HashMap; 
import java.util.Map;
class Solution {
    public static Map<Character, Integer> total = new HashMap<Character, Integer>();
	public static String [] def = {"RT", "CF", "JM","AN"};
    public String solution(String[] survey, int[] choices) {
        
        String answer="";
		
		for(int i=0;i<def.length;i++) {
			total.put(def[i].charAt(0), 0);
			total.put(def[i].charAt(1), 0);
			
		}
		
		for(int i=0; i<survey.length;i++) {
			if(choices[i]-4>0) {
				total.put(survey[i].charAt(1),total.getOrDefault(survey[i].charAt(1),0)+(choices[i]-4));
			}else if(choices[i]-4<0){
				total.put(survey[i].charAt(0),total.getOrDefault(survey[i].charAt(0),0)+(4-choices[i]));
			}
		}
		
		
		for(int i=0;i<def.length;i++) {
			int first = total.get(def[i].charAt(0));
			int end = total.get(def[i].charAt(1));
//			System.out.println(def[i].charAt(0)+": "+ first +"  VS  "+def[i].charAt(1)+": "+ end);
			if(first>end) {
				answer = answer+def[i].charAt(0);
			}else if(first==end) {
				if(def[i].charAt(0)>def[i].charAt(1)) {
					answer = answer+def[i].charAt(1);
				}else if(def[i].charAt(1)>def[i].charAt(0)){
					answer = answer+def[i].charAt(0);
				}
			} else {
				answer = answer+def[i].charAt(1);
			}
		}
        return answer;
    }
}