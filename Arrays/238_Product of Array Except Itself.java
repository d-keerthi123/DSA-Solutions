//Approach: Brute Force 
//TC:O(n^2)
//SC:O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int product=1; 
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    product*=nums[j];
                }
            }
            ans[i]=product;
        }

        return ans;
    }
}

//Approach : Using Division 
//TC:O(n)
//SC:O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];

        int product=1;
        int zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeros++;
            }else{
                product*=nums[i];
            }
        }

        for(int i=0;i<nums.length;i++){
            //current element is  non zero element
            if(nums[i]!=0){ 
                if(zeros==0){ // No zeros, normal division
                    ans[i]=product/nums[i];
                }
                //its not necessary to give else block bcz in java by default , it assigns zeros in the array
                
                // else{
                //     ans[i]=0; // If there's a zero, this element becomes 0
                // }
            }
            //current element is zero 
            else{
                if(zeros==1){ // If only one zero, put the product
                    ans[i]=product;
                }
                // else{
                //     ans[i]=0;// If more than one zero, everything is 0
                // }
            }
        }

        return ans;
    }
}
