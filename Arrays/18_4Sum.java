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

//TC:O(n^3) //O(n)*O(n)*O(n)
//SC:O(1)

class Solution {
    List<List<Integer>> result=new ArrayList<>();

    public void twoSum(int nums[],long target,int k,int l,int n1,int n2){ //O(n)
        while(k<l){
            long sum=(long)nums[k]+nums[l];
            if(sum >target){
                l--;
            }else if(sum <target){
                k++;
            }

            else{
                //check and remove duplicates
                while(k<l && nums[k]==nums[k+1]){
                    k++;
                }
                 while(k<l && nums[l]==nums[l-1]){
                    l--;
                }
                result.add(Arrays.asList(n1,n2,nums[k],nums[l]));
                //once we get answer move pointers
                k++;
                l--;
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        //sort array
        Arrays.sort(nums);

        //fixing n1 and n2
        for(int i=0;i<=n-4;i++){ //O(n)
            if(i>0 && nums[i]==nums[i-1]){//skip
                continue;
            }
            for(int j=i+1;j<=n-3;j++){ //O(n)
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int n1=nums[i];
                int n2=nums[j];
                long newTarget=(long) target-n1-n2;

                twoSum(nums,newTarget,j+1,n-1,n1,n2); //find n3 and n4
            }
        }

        return result;
    }
}
