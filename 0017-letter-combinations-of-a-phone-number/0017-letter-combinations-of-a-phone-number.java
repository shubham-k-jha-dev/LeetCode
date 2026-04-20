class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] arr = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        combinations(result, digits, arr, new StringBuilder(), 0);
        return result;
    }

    static void combinations(List<String> result, String digits, String[] arr, StringBuilder curr, int i) {
        if (i == digits.length()) {
            result.add(curr.toString());
            return;
        }

        String letters = arr[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            combinations(result, digits, arr, curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}