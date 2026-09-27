//Tc: O(n+m) bcz we are traversing all elements of both nums1 and nums2 arrays
//Sc:O(1) no extra space taken

//Approach :Two-pointer from the back:
class Solution {
    public static int[] mergeSort(int[] nums1, int m, int[] nums2, int n){

        int i = m - 1;// last actual element of nums1
        int j = n - 1;//last element of nums2
        int k = m + n - 1;//last position of nums1

        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }
        //remaining elements
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        return nums1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeSort(nums1,m,nums2,n);
    }
}
===================================================================================================================================================

//Time Complexity --> Linear time  O(m+n)
//Space Complexity --> Linear extra space  O(m+n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums[]= new int[n+m];
        int k=0;
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                nums[k]=nums1[i];
                i++;
                k++;
            }
            else{
                nums[k]=nums2[j];
                j++;
                k++;
            }
        }
        // merge remaining elements
        while(i<m){
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            nums[k]=nums2[j];
            j++;
            k++;
        }
        // copy merged array back into nums1
        for(int x=0;x<m+n;x++){
            nums1[x]=nums[x];
        }
    }
}
