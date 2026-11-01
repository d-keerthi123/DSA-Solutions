//TC:O(n^3)
//SC:O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int s=i;s<=j;s++){
                    sum+=nums[s];
                }
                if(sum==k){
                    count++;
                }
            }
        }

        return count;
    }
}
