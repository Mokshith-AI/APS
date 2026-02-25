class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr=new int[nums.length];
        int i=0,j=n,k=0;
        while(i<n&&j<nums.length&&k<nums.length){
            arr[k++]=nums[i++];
            arr[k++]=nums[j++];
        }
        return arr;
    }
}