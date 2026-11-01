//Approach :Brute force
//TC:O(n^2)
//SC:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }

        return -1;
    }
}


//Approach : Hashset
//TC:O(n)
//SC:O(n) due to hashset

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }

        return -1;
    }
}

