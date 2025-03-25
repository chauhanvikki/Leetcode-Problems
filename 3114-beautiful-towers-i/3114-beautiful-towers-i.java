
class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];
        
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSum[i] = (long) heights[i] * (i + 1);
            } else {
                leftSum[i] = leftSum[stack.peek()] + (long) heights[i] * (i - stack.peek());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSum[i] = (long) heights[i] * (n - i);
            } else {
                rightSum[i] = rightSum[stack.peek()] + (long) heights[i] * (stack.peek() - i);
            }
            stack.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, leftSum[i] + rightSum[i] - heights[i]);
        }

        return maxSum;
    }
}
