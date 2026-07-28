class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;

        long end = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        int mid = (int) (start + end) / 2;

        int speed = Integer.MAX_VALUE;

        while (start <= end) {

            long hours = 0;

            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] / mid);

                if (piles[i] % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                end = mid - 1;
                speed = Math.min(speed, mid);
            } else {
                start = mid + 1;
            }

            mid = (int) (start + end) / 2;
        }

        return speed;

    }
}