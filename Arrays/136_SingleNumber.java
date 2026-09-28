//Time Complexity O(n^2)
//Space Complexity O(1)

class Solution {
    public int singleNumber(int[] nums) {

    for(int i=0;i<nums.length;i++){
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
            }
        }
        if(count == 1){
            return nums[i];
        }
    } 
    return -1;
    }
}

===============================================================================================================================================================
//TC:O(n)
//SC:O(1)
//Approach : HashMap

 class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> mp=new HashMap<>();

        //count how many times each num occurs
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        // Find the number whose frequency is 1
        for(int num:mp.keySet()){
            if(mp.get(num)==1){
                return num;
            }
        }

        return -1;
    }
}
