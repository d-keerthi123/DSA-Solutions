//TC:O(n^2)
//SC:O(1)
//Brute Force -->Bubble sort

class Solution {
    public void sortColors(int[] nums) {
        
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    //swap
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}

================================================================================================================================
//TC:O(n)
//SC:O(1)
//Approach : Dutch National Flag 

class Solution {
    public void sortColors(int[] nums) {

        int n=nums.length;
        int i=0;  //denotes 0
        int j=0;  //denotes 1
        int k=n-1;//denotes 2

        while(j<=k){
            if(nums[j]==2){
                //swap value of j with k
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                k--;
            }

            else if(nums[j]==0){
                //swap value of j with i
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
                j++;
            }

            else{ //(nums[j]==1)
                j++;
            }
        }
    }
