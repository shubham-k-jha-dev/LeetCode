class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, result, n, new StringBuilder());
        return result;
    }

    static void generate(int open, int close, List<String> result, int n, StringBuilder curr) {
        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            generate(open + 1, close, result, n, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(')');
            generate(open, close + 1, result, n, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}