class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char [] arr = s.toCharArray();
        int pCount = 0;
        int yCount = 0;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i]=='P' || arr[i]=='p'){
                pCount++;
            }else if(arr[i]=='Y' || arr[i]=='y'){
                yCount++;
            }
        }
        
        
        if(pCount!=yCount){
            answer = false;
        }

        return answer;
    }
}