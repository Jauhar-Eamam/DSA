class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int minWeight = Integer.MIN_VALUE;
        int maxWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            minWeight = Math.max(minWeight, weights[i]);

            maxWeight += weights[i];
        }

        int midWeight = (minWeight + maxWeight) / 2;

        int resultWeight = Integer.MAX_VALUE;

        while (minWeight <= maxWeight) {

            int totalWeight = 0;
            int day = 1;

            for (int i = 0; i < weights.length; i++) {

                if ((totalWeight + weights[i]) <= midWeight) {
                    totalWeight += weights[i];
                } else {
                    day++;
                    if (day > days) {
                        break;
                    }
                    totalWeight = weights[i];
                }

            }
            
            if (day <= days) {
                resultWeight = Math.min(resultWeight, midWeight);
                maxWeight = midWeight - 1;
            } else {
                minWeight = midWeight + 1;
            }

            midWeight = (minWeight + maxWeight) / 2;

        }
        return resultWeight;
    }
}