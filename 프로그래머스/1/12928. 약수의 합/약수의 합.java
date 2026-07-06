class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean [] visited = new boolean[n+1];
        
        for(int i = 1; i<=n; i++){
            if(n%i==0){
                answer+= i;
            }
        }
        return answer;
    }
}