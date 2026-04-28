class Solution {
    static int answer = 0;
    static boolean [] visited;
    public int solution(int n, int[][] computers) {
       
        visited = new boolean [n];
        for(int i = 0 ; i<n; i++){
            if(visited[i]) continue;
            DFS(i,computers,n);
            answer++; 
        }
        
        return answer;
    }
    
    public static void DFS(int num, int [][] computers, int n){
        for(int j =0; j<n; j++){
            if(num==j) continue;
            if(visited[j] || computers [num][j]==0) continue;
            visited[j]=true;
            DFS(j,computers,n);
        }
        return;
    }
}