import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] result = new Solution().twoSum(nums, target);
        for (int i : result) {
            System.out.printf("%d ", i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
