//Time Complexity O(nxm) because for each element of nums1 we perform a linear search in nums2.
//Space Complexity O(n) stack, nextGreater array

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int nextGreater[]=new int[n];
        Stack<Integer> s= new Stack<>(); //Stores indices
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums2[s.peek()]<=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]=nums2[s.peek()];
            }
            s.push(i);
        }
        int m=nums1.length;
        int result[]=new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    result[i]=nextGreater[j];
                    break;
                }
            }
        }
    return result;
    }
}
