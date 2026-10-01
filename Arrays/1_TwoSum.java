//Time Complexity O(n^2)
//Space Complexity O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
      
      //Brute Force Approach
        for(int i=0;i<nums.length ;i++){
            for(int j=i+1 ;j<nums.length ;j++){
                if(nums[i] +nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

===============================================================================================================================================
//TC:O(n)
//SC:O(n)  Because in the worst case, we may store almost every element in the HashMap.
    
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
       HashMap<Integer,Integer> mp=new HashMap<>();

       for(int i=0;i<nums.length;i++){
        if(mp.containsKey(target-nums[i])){
            ans[0]=mp.get(target-nums[i]);
            ans[1]=i;

            return ans;
        }
           mp.put(nums[i],i);
       }

       return ans;
    }
}
