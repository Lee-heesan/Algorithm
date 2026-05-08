import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        List<Long> list = new LinkedList<>();
        
        long idx = left;
        long size = right-left+1;
        for(long i = 0; i<size; i++){
            list.add(Math.max((idx%n), (idx/n)) + 1);
            idx++;
        }
        
        
        return list;
    }
}