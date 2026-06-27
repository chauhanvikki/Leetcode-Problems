class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {

        int n = nums.size();
        if (n < k) return 0;

        long sum = 0;
        long ans = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        int distinct = 0;

        // Build the rightmost window
        int i = n - k;
        int j = n - 1;

        for (int x = i; x <= j; x++) {
            sum += nums.get(x);
            hm.put(nums.get(x), hm.getOrDefault(nums.get(x), 0) + 1);
            if (hm.get(nums.get(x)) == 1)
                distinct++;
        }

        if (distinct >= m)
            ans = sum;

        // Slide from right to left
        while (i > 0) {

            // Remove rightmost element
            int rem = nums.get(j);
            hm.put(rem, hm.get(rem) - 1);
            if (hm.get(rem) == 0) {
                hm.remove(rem);
                distinct--;
            }
            sum -= rem;
            j--;

            // Add new left element
            i--;
            int add = nums.get(i);
            sum += add;

            hm.put(add, hm.getOrDefault(add, 0) + 1);
            if (hm.get(add) == 1)
                distinct++;

            if (distinct >= m)
                ans = Math.max(ans, sum);
        }

        return ans;
    }
}