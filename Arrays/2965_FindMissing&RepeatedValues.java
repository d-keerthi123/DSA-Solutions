//Time Complexity: O(n²)
//Space Complexity: O(n²) (because of the frequency array which depends on input size n*n+1)
//If extra space depends on input size → it’s NOT O(1).

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n=grid.length; //row
        int m=grid[0].length; //col

        int freq[]=new int[n*n+1];
        int ans[]=new int[2];

        // Count frequency of every value
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                freq[grid[i][j]]++;
            }
        }

        for(int i=1;i<=n*n;i++){
            if(freq[i] == 2){
                ans[0]=i; //repeated value
            }

            if(freq[i]==0){
                ans[1]=i; //missing value
            }
        }
       return ans;
    }
}
