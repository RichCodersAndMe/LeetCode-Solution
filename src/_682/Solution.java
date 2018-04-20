package _682;

class Solution {
    public int calPoints(String[] ops) {
        int[] scores = new int[1000];
        int sum = 0;
        int i = 0;

        for (String op : ops) {
            if (op.charAt(0) == 'C') {
                sum -= scores[i--];
                continue;
            }

            i++;
            if (op.charAt(0) == '+') {
                scores[i] = scores[i-1] + scores[i-2];
            } else if (op.charAt(0) == 'D') {
                scores[i] = scores[i - 1] * 2;
            } else {
                scores[i] = Integer.valueOf(op);
            }
            sum += scores[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}