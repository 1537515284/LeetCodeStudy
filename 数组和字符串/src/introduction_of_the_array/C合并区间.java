package introduction_of_the_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }

        }
        return merged.toArray(new int[merged.size()][]);

    }
}
