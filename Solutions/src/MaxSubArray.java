/**
 * Find the contiguous subarray within an array
 *  (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class MaxSubArray{

    /**************************************
     *return the maxsum of the subArray
     * ************************************/
    public int maxSubArray(int[] nums) {
        if(null==nums || nums.length<1)return -1;
        if(nums.length==1)return nums[0];
        int tmp=nums[0];
        int maxsum = tmp;
        int i=1;
        for(;i<nums.length;++i){
            if(tmp<0)tmp=nums[i];
            else tmp += nums[i];
            if(tmp>maxsum)maxsum = tmp;
        }
        return maxsum;
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        msa.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}