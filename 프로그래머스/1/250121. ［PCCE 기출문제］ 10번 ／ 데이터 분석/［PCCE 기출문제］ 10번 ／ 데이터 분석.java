import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {   
        List<int[]> list = new ArrayList<>();
        String[] s = {"code", "date", "maximum", "remain"};
        
        int ext_i = getIdx(ext, s);
        int sort_i = getIdx(sort_by, s);
        
        for (int i = 0; i < data.length; i++) {
            if (val_ext > data[i][ext_i]) {
                list.add(data[i]);
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1[sort_i] - o2[sort_i]);
	    int[][] sortedData = list.toArray(new int[list.size()][4]);
        return sortedData;
    }
    private static int getIdx(String str, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                return i; // 인덱스를 반환
            }
        }
        return -1; // 찾지 못한 경우 -1 반환
    }
}