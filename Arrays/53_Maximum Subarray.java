//Approach 1:Brute Force
//TC:O(n^3)
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;

        for(int start=0;start<n;start++){
            for(int end=start;end<n;end++){
                int sum=0;  // Reset for every subarray
                for(int k=start;k<=end;k++){
                    sum+=nums[k];
                }
                maxSum=Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }
}

//Approach:Prefix Sum
//TC:O(n^2)
