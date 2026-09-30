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
