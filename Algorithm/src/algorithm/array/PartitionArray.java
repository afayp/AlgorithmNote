package algorithm.array;


/**
 *
 Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 All elements < k are moved to the left
 All elements >= k are moved to the right
 Return the partitioning index, i.e the first index i nums[i] >= k.
 Notice
 You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 If all elements in nums are smaller than k, then return nums.length

 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：

 所有小于k的元素移到左边
 所有大于等于k的元素移到右边
 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。


 */
public class PartitionArray {

    /**
     * 根据给定的k，也就是类似于Quick Sort中的pivot，将array从两头进行缩进，时间复杂度 O(n)
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        return left;
    }
}
