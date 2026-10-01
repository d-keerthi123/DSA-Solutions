//TC:O(n^3)
//SC:O(1) Auxiliary space

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<=n-3;i++){
            int n1=nums[i];

            for(int j=i+1;j<=n-2;j++){
                int n2=nums[j];

                for(int k=j+1;k<=n-1;k++){

                    int sum=n1+n2+nums[k];

                    if(sum==0){
                        List<Integer> ans=new ArrayList<>();
                        ans.add(n1);
                        ans.add(n2);
                        ans.add(nums[k]);

                        Collections.sort(ans);

                        if(!result.contains(ans)){
                            result.add(ans);
                        }
                    }
                }
            }
        }

        return result;
    }
}
======================================================================================================================================================
//TC:O(

class Solution {
    List<List<Integer>> result=new ArrayList<>();

    public void twoSum(int[] nums,int target,int i,int j){
        while(i<j){
            if(nums[i]+nums[j] >target){
                j--;
            }else if(nums[i]+nums[j] <target){
                i++;
            }else{
                //check and remove duplicates
                while(i<j && nums[i]==nums[i+1]){
                    i++;
                }
                 while(i<j && nums[j]==nums[j-1]){
                    j--;
                }
                result.add(Arrays.asList(-target,nums[i],nums[j]));
                //once we get answer move pointers
                i++;
                j--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n=nums.length;
        if(n<3){
            return result;
        }
        result.clear();

        //sort
        Arrays.sort(nums);

        //fixing n1
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){ //skip
                continue;
            }
            int n1=nums[i];
            int target=-(n1);

            twoSum(nums,target,i+1,n-1); //find n2 and n3
        }
        
        return result;
    }
}
