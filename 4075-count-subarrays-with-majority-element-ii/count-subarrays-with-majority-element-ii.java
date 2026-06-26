class Solution {
     class Fenwick {
        long[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
         int n = nums.length;

        Fenwick bit = new Fenwick(2 * n + 5);

        int offset = n + 2;
        int pref = 0;
        long ans = 0;

        bit.add(offset, 1);

        for (int x : nums) {
            if (x == target) {
                pref++;
            } else {
                pref--;
            }

            int idx = pref + offset;

            ans += bit.query(idx - 1);

            bit.add(idx, 1);
        }

        return ans;
    }
}