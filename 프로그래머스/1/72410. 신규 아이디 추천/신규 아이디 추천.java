class Solution {
    public String solution(String new_id) {
        // 1. 소문자로 치환
		new_id = new_id.toLowerCase();
		System.out.println(new_id);
		
		//2. 가능한 문자 이외 제거
        StringBuilder sb = new StringBuilder();
		for(char c : new_id.toCharArray()) {
			if((c>='a'&&c<='z')|| (c >= '0' && c <= '9') || c =='-' || c=='_' || c=='.' ) {
				sb.append(c);
			}
		}
		new_id = sb.toString();
		
		//3. . 연속 제거
		new_id = new_id.replaceAll("\\.{2,}", ".");
		
		//4. 처음 , 끝 . 제거
		new_id = new_id.replaceAll("^\\.|\\.$", "");
		
		//5.빈 문자열이면 a대입
		if(new_id.length()==0) {
			new_id="a";
		}
		//6. 16자 이상이면 15개 문자 이외의 숫자 제거
		if(new_id.length()>15) {
			new_id= new_id.substring(0,15);
		}
		
		//7. 제거 후 . 이 마지막이면 . 제거
		new_id = new_id.replaceAll("\\.$","");
		
		//8. 2자 이하면 마지막 문자를 길이 3이 될 떄까지 반복해서 붙임
		while(new_id.length()<3) {
			new_id = new_id+ new_id.charAt(new_id.length()-1);
		}
        
        return new_id;
    }
}