//TC:O(n^2)
//SC:O(1)

class Solution {
    public int maxArea(int[] height) {

        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<height.length-1;i++){
            int area=0;
            for(int j=i+1;j<height.length;j++){
                int h=Math.min(height[i],height[j]);
                int w=j-i;
                area=h*w;
                maxArea=Math.max(area,maxArea);
            }
        }

        return maxArea;
    }
}
=============================================================================================================================================================
  
//TC:O(n^2)
//SC:O(1)
//Approach : Two Pointers

class Solution {
    public int maxArea(int[] height) {

        int maxArea=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;

        while(i<=j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            int area=h*w;
            maxArea=Math.max(area,maxArea);

            // if(h==height[i]){
            //     i++;
            // }else{
            //     j--;
            // }
             if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }
}
