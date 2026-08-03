class Solution {
    public int hIndex(int[] citations) {

        int min = 1;
        int max = citations[citations.length - 1];

        int mid = (min + max) / 2;

        int result = 0;

        while (min <= max) {
            if (isHIndex(citations, mid)) {

                min = mid + 1;
                result = Math.max(result, mid);
            } else {
                max = mid - 1;
            }

            mid = (min + max) / 2;

        }

        return result;

    }

    public boolean isHIndex(int[] citations, int mid) {

        int length = citations.length;

        for (int i = 0; i < length; i++) {
            if ((length - i) >= mid) {
                if (citations[i] >= mid) {
                    return true;
                }
            } else {
                return false;
            }

        }

        return false;
    }
}