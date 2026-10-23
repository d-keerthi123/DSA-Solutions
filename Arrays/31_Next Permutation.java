//TC:O(n)
//SC:O(1)

class Solution {
    public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int candidateIdx=-1;
        int n=nums.length;

        //Find candidate
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                candidateIdx=i-1;
                break;
            }
        }

        //Find the next greater element in the right side of the candidate to swap
        if(candidateIdx !=-1){
            int swapIdx=candidateIdx;
            for(int i=n-1;i>candidateIdx;i--){
                if(nums[i]>nums[candidateIdx]){
                    swapIdx=i;
                    break;
                }
            }
            //swap
            swap(nums,candidateIdx,swapIdx);
        }
        //reverse rest after candidateIdx
        reverse(nums,candidateIdx+1,n-1);

    }
}
