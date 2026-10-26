//TC:O(nlogn) --> sorting takes \(O(n\log n)\), and merging takes \(O(n)\).
//Auxiliary space (O(n)) for the result list in the worst case, excluding sorting overhead.

class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        //First sort intervals
        Arrays.sort( intervals,(a,b)-> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);//add 1st interval 

        for(int i=1;i<n;i++){
            if( intervals[i][0] <= result.get(result.size()-1)[1]){ //overlapping
                int last[]=result.get(result.size()-1);
                last[1] = Math.max(last[1], intervals[i][1]);// ending max
            }else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
