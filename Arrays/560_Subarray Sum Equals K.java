//Approach:Brute force
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

//Approach: Hashmap
//TC:O(n)
//SC:O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int currSum=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
               count+= map.get(currSum-k);   
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
            
        }

        return count;
    }
}
