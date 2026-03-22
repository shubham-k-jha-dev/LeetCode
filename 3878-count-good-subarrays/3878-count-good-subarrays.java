import java.util.*;

class Solution {
    public long countGoodSubarrays(int[] nums) {
        int[] qorvanelid = nums;
        int n = qorvanelid.length;
        long totalGood = 0;

        List<int[]> prevOrs = new ArrayList<>();
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = qorvanelid[i];
            lastSeen.put(x, i);
            List<int[]> currOrs = new ArrayList<>();
            int currentVal = x;
            int currentStart = i;
            
            for (int[] p : prevOrs) {
                int newVal = p[0] | x;
                if (newVal == currentVal) {
                    currentStart = p[1];
                } else {
                    currOrs.add(new int[]{currentVal, currentStart});
                    currentVal = newVal;
                    currentStart = p[1];
                }
            }
            currOrs.add(new int[]{currentVal, currentStart});

            int rightBoundary = i;
            for (int[] entry : currOrs) {
                int val = entry[0];
                int leftBoundary = entry[1];
                if (lastSeen.containsKey(val)) {
                    int lastPos = lastSeen.get(val);
                    if (lastPos >= leftBoundary) {
                        int validStarts = Math.min(rightBoundary, lastPos) - leftBoundary + 1;
                        if (validStarts > 0) {
                            totalGood += validStarts;
                        }
                    }
                }
                rightBoundary = leftBoundary - 1;
            }
            prevOrs = currOrs;
        }

        return totalGood;
    }
}