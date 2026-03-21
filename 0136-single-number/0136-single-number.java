import java.util.*;

class Solution {
    public static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (hm.containsKey(key)) {
                int value = hm.get(key);
                hm.put(key, value + 1);
            } else {
                hm.put(key, 1);
            }
        }

        for (int key : hm.keySet()) {
            int value = hm.get(key);
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }
}