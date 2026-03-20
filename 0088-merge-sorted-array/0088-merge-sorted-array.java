import java.util.*;

class Solution {

    public static boolean isSorted(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (!isSorted(nums1, m)) {
            Arrays.sort(nums1, 0, m); 
        }

        if (!isSorted(nums2, n)) {
            Arrays.sort(nums2);
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums1 = new int[m];

        int n = sc.nextInt();
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1, m, nums2, n);
    }
}