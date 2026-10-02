//TC:O(n^4)
//SC:O(1)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        List<List<Integer>> result=new ArrayList<>();
        
        for(int i=0;i<=n-4;i++){
            int n1=nums[i];
            for(int j=i+1;j<=n-3;j++){
                int n2=nums[j];
                for(int k=j+1;k<=n-2;k++){
                    int n3=nums[k];
                    for(int l=k+1;l<=n-1;l++){
                        int sum=n1+n2+n3+nums[l];

                        if(sum==target){
                            List<Integer> ans=new ArrayList<>();
                            ans.add(n1);
                            ans.add(n2);
                            ans.add(n3);
                            ans.add(nums[l]);

                            Collections.sort(ans);

                            if(!result.contains(ans)){
                                result.add(ans);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
