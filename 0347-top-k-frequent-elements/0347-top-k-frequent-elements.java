import java.util.*;

class Solution {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqmap = new HashMap<>();

        for (int n : nums) {
            freqmap.put(n, freqmap.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freqmap.keySet()) {
            int frequency = freqmap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {

            if (bucket[pos] != null) {

                for (Integer num : bucket[pos]) {
                    res[counter++] = num;

                    if (counter == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] result = topKFrequent(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}