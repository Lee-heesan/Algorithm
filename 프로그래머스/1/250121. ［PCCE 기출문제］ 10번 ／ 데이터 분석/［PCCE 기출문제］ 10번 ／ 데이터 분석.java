import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int ext_i = search_i(ext);
		int sort_i = search_i(sort_by);
        List<int[]> tempList = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (val_ext > data[i][ext_i]) {
                tempList.add(data[i]);
            }
        }

        int[][] sortDatas = tempList.toArray(new int[tempList.size()][]);

		
		Arrays.sort(sortDatas, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[sort_i]-o2[sort_i];
			}
		});
        return sortDatas;
    }
    public static int search_i(String data) {
		int result=0;
		if(data.equals("code")) {
			result=0;
		}else if(data.equals("date")) {
			result=1;
		}else if(data.equals("maximum")) {
			result=2;
		}else if(data.equals("remain")) {
			result=3;
		}
		
		return result;
	}
}