class Solution {
    public int hIndex(int[] citations) {

        int minCitations = 1;
        int maxCitations = citations[citations.length - 1];

        int midCitations = (minCitations + maxCitations) / 2;

        int resultOfHIndex = 0;

        while (minCitations <= maxCitations) {
            if (isHIndex(citations, midCitations)) {

                minCitations = midCitations + 1;
                resultOfHIndex = Math.max(resultOfHIndex, midCitations);
            } else {
                maxCitations = midCitations - 1;
            }

            midCitations = (minCitations + maxCitations) / 2;

        }

        return resultOfHIndex;

    }

    public boolean isHIndex(int[] citations, int midCitations) {

        int lengthOfCitations = citations.length;

        for (int i = 0; i < lengthOfCitations; i++) {
            if ((lengthOfCitations - i) >= midCitations) {
                if (citations[i] >= midCitations) {
                    return true;
                }
            } else {
                return false;
            }

        }

        return false;
    }
}