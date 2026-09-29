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
==========================================================================================================================================
//Approach:Prefix Sum
//TC:O(n^2)
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;

        for(int start=0;start<n;start++){
            int currSum=0;
            for(int end=start;end<n;end++){
                currSum+=nums[end];
                maxSum=Math.max(currSum,maxSum);
            }
        }
        return maxSum;
    }
}
==========================================================================================================================
//Approach : Kadane's Algorithm
//TC:O(n)
//SC:O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            maxSum=Math.max(currSum,maxSum);

            if(currSum<0){
                currSum=0;
            }
        }

        return maxSum;
    }
}
