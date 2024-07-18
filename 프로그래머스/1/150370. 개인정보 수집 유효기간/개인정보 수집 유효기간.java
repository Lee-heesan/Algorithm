import java.util.ArrayList; 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Integer[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<Integer>();
		
		//유효기간 검사 전 준비과정
		String [] now = today.split("\\.");
		int year = Integer.parseInt(now[0]);
		int month = Integer.parseInt(now[1]);
		int day = Integer.parseInt(now[2]);
		Date ttoday = new Date(year,month,day);
		
		Map<String, Integer> term = new HashMap<String, Integer>();
		for(int i=0; i<terms.length;i++) {
			String [] str = terms[i].split(" ");
			term.put(str[0], Integer.parseInt(str[1]));
		}
		
		//검사 시작
		for(int i=0;i<privacies.length;i++) {
			String [] privacy = privacies[i].split(" ");
			String []firstDay = privacy[0].split("\\.");
			int p_term = term.get(privacy[1]);
			int lastYear, lastMonth, lastDay;
			if(p_term+Integer.parseInt(firstDay[1])>12) {
				lastYear = Integer.parseInt(firstDay[0])+((Integer.parseInt(firstDay[1])+p_term)/12);
				lastMonth =(Integer.parseInt(firstDay[1])+p_term)%12;
			}else {
				lastYear=Integer.parseInt(firstDay[0]);
				lastMonth =Integer.parseInt(firstDay[1])+p_term;
			}
			lastDay = Integer.parseInt(firstDay[2]);
			Date lastDate = new Date(lastYear,lastMonth,lastDay);
			
			if(lastDate.before(ttoday)||lastDate.equals(ttoday)) {
				answers.add(i+1);
			}

		}
		Integer[] answer = answers.toArray(new Integer[answers.size()]);
        return answer;
    }
}