class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int min = intervals[0][0];
        int max = intervals[0][1];

        for(int i = 0; i < intervals.length; i ++ ){
            
            if(max < intervals[i][0]){
                result.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
            else{
                max = Math.max(max, intervals[i][1]);
            }
        }
        result.add(new int[]{min, max});
        
        return result.toArray(new int[result.size()][]);
    }
}
