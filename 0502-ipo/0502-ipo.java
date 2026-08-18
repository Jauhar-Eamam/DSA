class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int n = profits.length;

        int[][] pairArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairArr[i][0] = capital[i];
            pairArr[i][1] = profits[i];
        }

        Arrays.sort(pairArr,
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(a[1], b[1]);
                    }
                });

        int indx = 0;

        while (k > 0) {

            while (indx < n) {
                if (pairArr[indx][0] > w) {
                    break;
                } else {
                    maxHeap.add(pairArr[indx][1]);
                }

                indx++;
            }

            if (maxHeap.isEmpty()) {
                return w;
            } else {
                w += maxHeap.poll();
            }

            k--;

        }

        return w;

    }
}