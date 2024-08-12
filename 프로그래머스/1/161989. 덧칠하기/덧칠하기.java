class Solution {
    public int solution(int n, int m, int[] section) {
        int answer=0;
		
		boolean [] arr = new boolean[n];
		
		for(int i =0; i<section.length; i++) {
			arr[section[i]-1] = true;
		}
		
		
		for(int i =section[0]-1; i<n; i++) {
			if(arr[i]==true) {
				int finish = i+m-1;

				arr[i]=false;
				
				if(finish>n-1) {
					finish=n-1;
				}
				
				while(i<finish) {
					arr[++i]=false;
				}
				answer++;
			}
		}
        return answer;
    }
}