class Solution {
    public int solution(int n, int w, int num) { 
        // n 박스 개수, w 가로로 상자, num 꺼내려는 택배 상자의 번호
        // result 는 꺼내야하는 상자
        int result = 0;
        int [][] arr = new int [101][101];
        
        int wCount = 1;
        
        int x = 1;
        int y = 1;
        boolean Right = true;
        int posX = 0;
        int posY = 0;
        
        while(wCount<=n){
            arr[y][x] = wCount;
            if(arr[y][x]== num){
                posX = x;
                posY = y;
            }
            wCount++;
            if(Right){
                x++;
            }else{
                x--;
            }
            
            if(x<1||x>w){
                y++;
                
                if(x<1){
                    x=1;
                    Right = true;
                }else{
                    x=w;
                    Right = false;
                }
            }
        }
        
        while(arr[posY][posX]!=0){
            result++;
            posY++;
        }
        
        return result;
    }
}