class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int insertPos = 0;

        // First pass: move all non-zero elements to the left
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Second pass: fill the remaining positions with zero
        while (insertPos < n) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
