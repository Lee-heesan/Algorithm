import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static Integer maxKey, minKey;
	public static Integer maxValue=-1,minValue=51;
    public int[] solution(String[] wallpaper) {
        Map<Integer, List<Integer>> arr = new HashMap<Integer, List<Integer>>(); 
		
		for(int i =0; i<wallpaper.length;i++) {
			if(wallpaper[i].contains("#")) {
				for(int j=0;j<wallpaper[i].length();j++){
					if(wallpaper[i].charAt(j)=='#') {
						arr.put(i, new ArrayList<Integer>());
						arr.get(i).add(j);
						if(j<minValue) {
							minValue=j;
						}
						if(j+1>maxValue) {
							maxValue=j+1;
						}
					}
				}
			}
		}
		
		maxKey = Collections.max(arr.keySet())+1;
		minKey = Collections.min(arr.keySet());
		int[] result = {minKey,minValue,maxKey,maxValue};
        return result;
    }
}