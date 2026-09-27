class Solution {
    public int majorityElement(int[] nums) {

        //Brute Force Approach O(n^2)
        // int maxCount=Integer.MIN_VALUE;
        // int maxElement=-1;
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        //     //update maxCount
        //     if(count > maxCount){
        //         maxCount=count;
        //         maxElement=nums[i];
        //     }
        // }
        // return maxElement;

        //Boyer-Moore Voting Approach O(n)
        int count=0; //its current "vote count"
        int candidate=0; //the element currently considered as the majority
        for(int num :nums){
            if(count==0){  // choose curr element as candidate
                candidate=num;
            }
            //if curr element equals candidate --> count++ 
            //else count--
            count += (num == candidate)? 1: -1;

        }
        // majority element survives all cancellations 
        return candidate;

        //HashMap Approach O(n)
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(hm.containsKey(num)){
                //if key already exits in the hash map
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }

        Set<Integer> keys=hm.keySet();
        for(Integer key:keys){
            if(hm.get(key)> n/2){
                return key;
            }
        }
        return -1;
    }
}
