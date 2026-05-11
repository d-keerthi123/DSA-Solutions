//TC:O(n^2) nested loop
//SC:O(n) result array

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //brute force
        int result[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){

            result[i]=-1; // default if no greater found

            for(int j=1;j<nums.length;j++){ //step count
                int k=(i+j) % nums.length; //So after last index, go to first index.
                if(nums[k]>nums[i]){
                    result[i]=nums[k];
                    break;
                }
               
            }
        }
        return result;
    }
}
